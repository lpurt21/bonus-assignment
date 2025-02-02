package com.scheme.utils;

import com.scheme.expression.*;
import com.scheme.expression.function.DefineExpression;
import com.scheme.expression.function.DefineFunctionExpression;
import com.scheme.expression.function.LambdaExpression;
import com.scheme.expression.function.QuoteExpression;
import com.scheme.expression.logical.AndExpression;
import com.scheme.expression.logical.IfExpression;
import com.scheme.expression.logical.OrExpression;
import com.scheme.expression.types.*;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final List<String> tokens;
    private int position = 0;

    public Parser(List<String> tokens) {
        this.tokens = tokens;
    }

    public Expression parse() {
        if (tokens.isEmpty()) {
            throw new RuntimeException("Unexpected EOF");
        }
        String token = tokens.get(position++);
        if (token.equals("(")) {
            List<Expression> list = new ArrayList<>();
            while (!tokens.get(position).equals(")")) {
                list.add(parse());
            }
            position++; // Consume ')'
            if (!list.isEmpty() && list.get(0) instanceof SymbolExpression) {
                SymbolExpression first = (SymbolExpression) list.get(0);
                String name = first.getName();
                switch (name) {
                    case "define":
                        return parseDefine(list);
                    case "lambda":
                        return parseLambda(list);
                    case "if":
                        return parseIf(list);
                    case "or":
                        return parseOr(list);
                    case "and":
                        return parseAnd(list);
                    case "quote":
                        return parseQuote(list);
                    default:
                        return new ListExpression(list);
                }
            }
            return new ListExpression(list);
        } else if (token.equals("'")) {
            return new QuoteExpression(parse());
        } else if (token.equals(")")) {
            throw new RuntimeException("Unexpected )");
        } else {
            return atom(token);
        }
    }

    private Expression parseIf(List<Expression> list) {
        if (list.size() != 4) {
            throw new RuntimeException("Invalid if expression: expected 3 parts (condition, consequent, alternative)");
        }

        Expression condition = list.get(1);
        Expression consequent = list.get(2);
        Expression alternative = list.get(3);

        return new IfExpression(condition, consequent, alternative);
    }
    private Expression parseDefine(List<Expression> list) {
        if (list.size() < 3) {
            throw new RuntimeException("Invalid define expression");
        }

        if (list.get(1) instanceof SymbolExpression) {
            SymbolExpression variable = (SymbolExpression) list.get(1);
            Expression value = list.get(2);
            return new DefineExpression(variable, value);
        }

        if (list.get(1) instanceof ListExpression) {
            ListExpression functionDef = (ListExpression) list.get(1);
            if (functionDef.getExpressions().isEmpty() || !(functionDef.getExpressions().get(0) instanceof SymbolExpression)) {
                throw new RuntimeException("Invalid function definition");
            }
            SymbolExpression functionName = (SymbolExpression) functionDef.getExpressions().get(0);
            List<SymbolExpression> parameters = new ArrayList<>();
            for (int i = 1; i < functionDef.getExpressions().size(); i++) {
                if (!(functionDef.getExpressions().get(i) instanceof SymbolExpression)) {
                    throw new RuntimeException("Invalid parameter in function definition");
                }
                parameters.add((SymbolExpression) functionDef.getExpressions().get(i));
            }
            Expression body = list.get(2);
            return new DefineFunctionExpression(functionName, parameters, body);
        }

        throw new RuntimeException("Invalid define expression");
    }

    private Expression parseLambda(List<Expression> list) {
        if (list.size() < 3) {
            throw new RuntimeException("Invalid lambda expression");
        }

        if (!(list.get(1) instanceof ListExpression)) {
            throw new RuntimeException("Invalid parameter list in lambda");
        }
        List<SymbolExpression> parameters = new ArrayList<>();
        for (Expression param : ((ListExpression) list.get(1)).getExpressions()) {
            if (!(param instanceof SymbolExpression)) {
                throw new RuntimeException("Invalid parameter in lambda");
            }
            parameters.add((SymbolExpression) param);
        }

        Expression body = list.get(2);

        return new LambdaExpression(parameters, body);
    }

    private Expression atom(String token) {
        if (token.startsWith("\"") && token.endsWith("\"")) {
            return new StringExpression(token.substring(1, token.length() - 1));
        } else if (token.equals("#t")) {
            return new BooleanExpression(true);
        } else if (token.equals("#f")) {
            return new BooleanExpression(false);
        }
        try {
            return new NumberExpression(Integer.parseInt(token));
        } catch (NumberFormatException e1) {
            try {
                return new DoubleExpression(Double.parseDouble(token));
            } catch (NumberFormatException e2) {
                return new SymbolExpression(token);
            }
        }
    }

    private Expression parseQuote(List<Expression> list) {
        if (list.size() != 2) {
            throw new RuntimeException("Invalid quote expression: expected exactly 1 argument");
        }
        return new QuoteExpression(list.get(1));
    }

    private Expression parseOr(List<Expression> list) {
        return new OrExpression(list.subList(1, list.size()));
    }

    private Expression parseAnd(List<Expression> list) {
        return new AndExpression(list.subList(1, list.size()));
    }

    public int getPosition() {
        return position;
    }
}

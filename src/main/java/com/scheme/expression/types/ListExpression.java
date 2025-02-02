package com.scheme.expression.types;

import com.scheme.expression.Expression;
import com.scheme.utils.Environment;
import com.scheme.procedures.Procedure;

import java.util.ArrayList;
import java.util.List;

public class ListExpression implements Expression {
    private final List<Expression> expressions;

    public ListExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public Object evaluate(Environment env) {
        if (expressions.isEmpty()) {
            throw new RuntimeException("Empty list cannot be evaluated");
        }

        Expression first = expressions.get(0);
        Object procedure = first.evaluate(env);

        List<Object> args = new ArrayList<>();
        for (int i = 1; i < expressions.size(); i++) {
            args.add(expressions.get(i).evaluate(env));
        }

        return apply(procedure, args, env);
    }

    private Object apply(Object procedure, List<Object> args, Environment env) {
        if (procedure instanceof Procedure) {
            return ((Procedure) procedure).apply(args, env);
        } else {
            throw new RuntimeException("Unknown procedure: " + procedure);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < expressions.size(); i++) {
            sb.append(expressions.get(i).toString());
            if (i < expressions.size() - 1) {
                sb.append(" ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public List<Expression> getExpressions() {
        return expressions;
    }
}

package com.scheme.expression.function;

import com.scheme.expression.Expression;
import com.scheme.expression.types.SymbolExpression;
import com.scheme.procedures.built_in.LambdaProcedure;
import com.scheme.utils.Environment;

import java.util.List;

public class LambdaExpression implements Expression {
    private final List<SymbolExpression> parameters;
    private final Expression body;

    public LambdaExpression(List<SymbolExpression> parameters, Expression body) {
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public Object evaluate(Environment env) {
        return new LambdaProcedure(parameters, body, env);
    }
}

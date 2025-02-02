package com.scheme.expression.logical;

import com.scheme.expression.Expression;
import com.scheme.utils.Environment;

import java.util.List;

public class OrExpression implements Expression {
    private final List<Expression> expressions;

    public OrExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public Object evaluate(Environment env) {
        for (Expression expr : expressions) {
            Object result = expr.evaluate(env);
            if (isTruthy(result)) {
                return result;
            }
        }
        return false;
    }

    private boolean isTruthy(Object value) {
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        return true;
    }
}
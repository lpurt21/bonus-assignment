package com.scheme.expression.logical;

import com.scheme.expression.Expression;
import com.scheme.utils.Environment;

import java.util.List;

public class AndExpression implements Expression {
    private final List<Expression> expressions;

    public AndExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public Object evaluate(Environment env) {
        Object lastResult = true;
        for (Expression expr : expressions) {
            lastResult = expr.evaluate(env);
            if (!isTruthy(lastResult)) {
                return lastResult;
            }
        }
        return lastResult;
    }

    private boolean isTruthy(Object value) {
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        return true;
    }
}

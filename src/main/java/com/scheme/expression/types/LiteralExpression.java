package com.scheme.expression.types;

import com.scheme.expression.Expression;
import com.scheme.utils.Environment;

public class LiteralExpression implements Expression {
    private final Object value;

    public LiteralExpression(Object value) {
        this.value = value;
    }

    @Override
    public Object evaluate(Environment env) {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
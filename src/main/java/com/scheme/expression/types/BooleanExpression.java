package com.scheme.expression.types;

import com.scheme.expression.Expression;
import com.scheme.utils.Environment;

public class BooleanExpression implements Expression {
    private final boolean value;

    public BooleanExpression(boolean value) {
        this.value = value;
    }

    @Override
    public Object evaluate(Environment env) {
        return value;
    }
}

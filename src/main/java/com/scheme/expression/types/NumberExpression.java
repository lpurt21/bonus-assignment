package com.scheme.expression.types;

import com.scheme.expression.Expression;
import com.scheme.utils.Environment;

public class NumberExpression implements Expression {
    private final int value;

    public NumberExpression(int value) {
        this.value = value;
    }

    @Override
    public Object evaluate(Environment env) {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

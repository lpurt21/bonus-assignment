package com.scheme.expression.types;

import com.scheme.expression.Expression;
import com.scheme.utils.Environment;

public class DoubleExpression implements Expression {

    private final double value;

    public DoubleExpression(double value) {
        this.value = value;
    }

    @Override
    public Object evaluate(Environment env) {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}

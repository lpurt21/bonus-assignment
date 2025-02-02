package com.scheme.expression.types;

import com.scheme.expression.Expression;
import com.scheme.utils.Environment;

public class SymbolExpression implements Expression {
    private final String name;

    public SymbolExpression(String name) {
        this.name = name;
    }

    @Override
    public Object evaluate(Environment env) {
        return env.lookup(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

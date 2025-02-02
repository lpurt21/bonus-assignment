package com.scheme.expression.function;

import com.scheme.expression.Expression;
import com.scheme.expression.types.SymbolExpression;
import com.scheme.utils.Environment;

public class DefineExpression implements Expression {
    private final SymbolExpression variable;
    private final Expression value;

    public DefineExpression(SymbolExpression variable, Expression value) {
        this.variable = variable;
        this.value = value;
    }

    @Override
    public Object evaluate(Environment env) {
        Object evaluatedValue = value.evaluate(env);
        env.define(variable.getName(), evaluatedValue);
        return null; // define doesn't return a value
    }
}

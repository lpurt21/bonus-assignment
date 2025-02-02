package com.scheme.expression.function;

import com.scheme.expression.Expression;
import com.scheme.utils.Environment;

public class QuoteExpression implements Expression {
    private final Expression quotedExpression;

    public QuoteExpression(Expression quotedExpression) {
        this.quotedExpression = quotedExpression;
    }

    @Override
    public Object evaluate(Environment env) {
        return quotedExpression;
    }

    @Override
    public String toString() {
        return "'" + quotedExpression.toString();
    }
}
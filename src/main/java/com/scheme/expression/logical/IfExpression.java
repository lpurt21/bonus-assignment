package com.scheme.expression.logical;

import com.scheme.expression.Expression;
import com.scheme.utils.Environment;

public class IfExpression implements Expression {
    private final Expression condition;
    private final Expression consequent;
    private final Expression alternative;

    public IfExpression(Expression condition, Expression consequent, Expression alternative) {
        this.condition = condition;
        this.consequent = consequent;
        this.alternative = alternative;
    }

    @Override
    public Object evaluate(Environment env) {
        Object conditionValue = condition.evaluate(env);
        if (!(conditionValue instanceof Boolean)) {
            throw new RuntimeException("Condition must evaluate to a boolean");
        }
        if ((Boolean) conditionValue) {
            return consequent.evaluate(env);
        } else {
            return alternative.evaluate(env);
        }
    }
}
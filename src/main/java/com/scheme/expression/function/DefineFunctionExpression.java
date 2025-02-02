package com.scheme.expression.function;

import com.scheme.expression.Expression;
import com.scheme.expression.types.SymbolExpression;
import com.scheme.procedures.built_in.LambdaProcedure;
import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class DefineFunctionExpression implements Expression {
    private final SymbolExpression functionName;
    private final List<SymbolExpression> parameters;
    private final Expression body;

    public DefineFunctionExpression(SymbolExpression functionName, List<SymbolExpression> parameters, Expression body) {
        this.functionName = functionName;
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public Object evaluate(Environment env) {
        Procedure lambda = new LambdaProcedure(parameters, body, env);
        env.define(functionName.getName(), lambda);
        return null;
    }
}

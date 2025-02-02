package com.scheme.procedures.built_in;

import com.scheme.expression.Expression;
import com.scheme.expression.types.SymbolExpression;
import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class LambdaProcedure implements Procedure {
    private final List<SymbolExpression> parameters;
    private final Expression body;
    private final Environment definitionEnv;

    public LambdaProcedure(List<SymbolExpression> parameters, Expression body, Environment definitionEnv) {
        this.parameters = parameters;
        this.body = body;
        this.definitionEnv = definitionEnv;
    }

    @Override
    public Object apply(List<Object> args, Environment env) {
        Environment lambdaEnv = new Environment(definitionEnv);

        if (args.size() != parameters.size()) {
            throw new RuntimeException("Expected " + parameters.size() + " arguments, but got " + args.size());
        }
        for (int i = 0; i < parameters.size(); i++) {
            lambdaEnv.define(parameters.get(i).getName(), args.get(i));
        }

        return body.evaluate(lambdaEnv);
    }
}

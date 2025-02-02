package com.scheme.procedures.built_in;

import com.scheme.expression.types.ListExpression;
import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.ArrayList;
import java.util.List;

public class ApplyProcedure implements Procedure {

    @Override
    public Object apply(List<Object> args, Environment env) {
        if (args.size() < 2) {
            throw new RuntimeException("apply requires at least 2 arguments");
        }
        Object procedure = args.get(0);
        if (!(procedure instanceof Procedure)) {
            throw new RuntimeException("apply first argument must be a procedure");
        }
        Object lastArg = args.get(args.size() - 1);
        if (!(lastArg instanceof ListExpression)) {
            throw new RuntimeException("apply last argument must be a list");
        }
        List<Object> allArgs = new ArrayList<>();
        for (int i = 1; i < args.size() - 1; i++) {
            allArgs.add(args.get(i));
        }
        allArgs.addAll(((ListExpression) lastArg).getExpressions().stream()
                .map(expr -> expr.evaluate(env))
                .toList());
        return ((Procedure) procedure).apply(allArgs, env);
    }
}

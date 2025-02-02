package com.scheme.procedures.built_in;

import com.scheme.expression.Expression;
import com.scheme.expression.types.ListExpression;
import com.scheme.expression.types.LiteralExpression;
import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.ArrayList;
import java.util.List;

public class MapProcedure implements Procedure {

    @Override
    public Object apply(List<Object> args, Environment env) {
        if (args.size() != 2) {
            throw new RuntimeException("map requires exactly 2 arguments");
        }
        Object procedure = args.get(0);
        if (!(procedure instanceof Procedure)) {
            throw new RuntimeException("map first argument must be a procedure");
        }
        Object listArg = args.get(1);
        if (!(listArg instanceof ListExpression)) {
            throw new RuntimeException("map second argument must be a list");
        }
        List<Expression> list = ((ListExpression) listArg).getExpressions();
        List<Expression> result = new ArrayList<>();
        for (Expression expr : list) {
            Object evaluatedExpr = expr.evaluate(env);
            Object mappedValue = ((Procedure) procedure).apply(List.of(evaluatedExpr), env);
            result.add(new LiteralExpression(mappedValue));
        }
        return new ListExpression(result);
    }
}
package com.scheme.procedures.built_in;

import com.scheme.expression.Expression;
import com.scheme.expression.types.ListExpression;
import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class CarProcedure implements Procedure {
    @Override
    public Object apply(List<Object> args, Environment env) {
        if (args.size() != 1) {
            throw new RuntimeException("car requires exactly 1 argument");
        }
        Object arg = args.get(0);
        if (!(arg instanceof ListExpression)) {
            throw new RuntimeException("car argument must be a list");
        }
        List<Expression> list = ((ListExpression) arg).getExpressions();
        if (list.isEmpty()) {
            throw new RuntimeException("car of empty list");
        }
        return list.get(0).evaluate(env);
    }
}

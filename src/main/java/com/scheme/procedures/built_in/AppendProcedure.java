package com.scheme.procedures.built_in;

import com.scheme.expression.Expression;
import com.scheme.expression.types.ListExpression;
import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.ArrayList;
import java.util.List;

public class AppendProcedure implements Procedure {
    @Override
    public Object apply(List<Object> args, Environment env) {
        if (args.isEmpty()) {
            throw new RuntimeException("append requires at least 1 argument");
        }
        List<Expression> result = new ArrayList<>();
        for (Object arg : args) {
            if (!(arg instanceof ListExpression)) {
                throw new RuntimeException("append arguments must be lists");
            }
            result.addAll(((ListExpression) arg).getExpressions());
        }
        return new ListExpression(result);
    }
}
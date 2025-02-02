package com.scheme.procedures.built_in;

import com.scheme.expression.Expression;
import com.scheme.expression.types.ListExpression;
import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class CdrProcedure implements Procedure {
    @Override
    public Object apply(List<Object> args, Environment env) {
        if (args.size() != 1) {
            throw new RuntimeException("cdr requires exactly 1 argument");
        }
        Object arg = args.get(0);
        if (!(arg instanceof ListExpression)) {
            throw new RuntimeException("cdr argument must be a list");
        }
        List<Expression> list = ((ListExpression) arg).getExpressions();
        if (list.isEmpty()) {
            throw new RuntimeException("cdr of empty list");
        }
        return new ListExpression(list.subList(1, list.size()));
    }
}
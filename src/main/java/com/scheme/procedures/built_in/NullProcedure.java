package com.scheme.procedures.built_in;

import com.scheme.expression.types.ListExpression;
import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class NullProcedure implements Procedure {

    @Override
    public Object apply(List<Object> args, Environment env) {
        if (args.size() != 1) {
            throw new RuntimeException("null? requires exactly 1 argument");
        }
        Object arg = args.get(0);
        if (arg instanceof ListExpression) {
            return ((ListExpression) arg).getExpressions().isEmpty();
        }
        return false;
    }
}

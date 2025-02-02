package com.scheme.procedures.built_in;

import com.scheme.expression.Expression;
import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class EvalProcedure implements Procedure {
    @Override
    public Object apply(List<Object> args, Environment env) {
        if (args.size() != 1) {
            throw new RuntimeException("eval requires exactly 1 argument");
        }
        Object arg = args.get(0);
        if (!(arg instanceof Expression)) {
            throw new RuntimeException("eval argument must be an expression");
        }
        return ((Expression) arg).evaluate(env);
    }
}

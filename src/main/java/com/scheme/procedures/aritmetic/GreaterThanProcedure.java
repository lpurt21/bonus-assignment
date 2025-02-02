package com.scheme.procedures.aritmetic;

import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class GreaterThanProcedure implements Procedure {
    @Override
    public Object apply(List<Object> args, Environment env) {
        if (args.size() != 2) {
            throw new RuntimeException("> requires exactly 2 arguments");
        }
        if (!(args.get(0) instanceof Number) || !(args.get(1) instanceof Number)) {
            throw new RuntimeException("> requires numeric arguments");
        }
        double a = ((Number) args.get(0)).doubleValue();
        double b = ((Number) args.get(1)).doubleValue();
        return a > b;
    }
}
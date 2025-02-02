package com.scheme.procedures.aritmetic;

import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class MinusProcedure implements Procedure {
    @Override
    public Object apply(List<Object> args, Environment env) {
        if (args.isEmpty()) {
            throw new RuntimeException("No arguments provided for -");
        }

        if (!(args.get(0) instanceof Number)) {
            throw new RuntimeException("Invalid argument type for -: " + args.get(0));
        }

        double result = ((Number) args.get(0)).doubleValue();
        boolean hasDouble = false;

        if (args.size() == 1) {
            return -(int) result;
        }

        for (int i = 1; i < args.size(); i++) {
            if (!(args.get(i) instanceof Number)) {
                throw new RuntimeException("Invalid argument type for -: " + args.get(i));
            }

            if (args.get(i) instanceof Double || args.get(i) instanceof Float) {
                hasDouble = true;
            }

            double currentValue = ((Number) args.get(i)).doubleValue();
            result -= currentValue;
        }

        if (hasDouble) {
            return result;
        } else {
            return (int) result;
        }
    }
}
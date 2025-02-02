package com.scheme.procedures.aritmetic;

import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class AddProcedure implements Procedure {
    @Override
    public Object apply(List<Object> args, Environment env) {
        int sumInt = 0;
        double sumDouble = 0.0;
        boolean hasDouble = false;

        for (Object arg : args) {
            if (!(arg instanceof Number)) {
                throw new RuntimeException("Invalid argument type for +: " + arg);
            }

            if (arg instanceof Double || arg instanceof Float) {
                hasDouble = true;
                sumDouble += ((Number) arg).doubleValue();
            } else {
                sumInt += ((Number) arg).intValue();
            }
        }

        if (hasDouble) {
            return sumDouble + sumInt;
        } else {
            return sumInt;
        }
    }
}
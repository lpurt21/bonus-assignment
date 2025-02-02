package com.scheme.procedures.aritmetic;

import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class AddProcedure implements Procedure {
    @Override
    public Object apply(List<Object> args, Environment env) {
        double sum = 0;
        for (Object arg : args) {
            if (arg instanceof Number) {
                sum += ((Number) arg).doubleValue();
            } else {
                throw new RuntimeException("Invalid argument type for +: " + arg);
            }
        }
        return sum;
    }
}
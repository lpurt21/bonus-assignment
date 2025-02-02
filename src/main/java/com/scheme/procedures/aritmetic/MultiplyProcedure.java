package com.scheme.procedures.aritmetic;

import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class MultiplyProcedure implements Procedure {
    @Override
    public Object apply(List<Object> args, Environment env) {

        int product = 1;
        for(Object arg : args) {
            if(!(arg instanceof Integer)) {
                throw new RuntimeException("argument is not an integer");
            }
            product *= (Integer) arg;
        }
        return product;
    }
}

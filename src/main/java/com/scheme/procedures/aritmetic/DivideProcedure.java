package com.scheme.procedures.aritmetic;

import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class DivideProcedure implements Procedure {

    @Override
    public Object apply(List<Object> args, Environment env) {
        if(args.isEmpty()){
            throw new RuntimeException("empty list of arguments");
        }
        int res = 1;
        if(args.size() == 1){
            if(!(args.get(0) instanceof Integer))
                throw new RuntimeException("argument must be an integer");

            res = (Integer) args.get(0);
            if(res == 0)
                throw new RuntimeException("argument cannot be zero");
            return  1.0 / res;
        }
        for (int i = 1; i < args.size(); i++) {
            if (!(args.get(i) instanceof Integer)) {
                throw new RuntimeException("Invalid argument type for /: " + args.get(i));
            }
            int divisor = (Integer) args.get(i);
            if (divisor == 0) {
                throw new RuntimeException("Division by zero");
            }
            res /= divisor;
        }
        return res;
    }
}

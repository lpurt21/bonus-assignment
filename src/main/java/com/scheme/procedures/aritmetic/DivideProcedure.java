package com.scheme.procedures.aritmetic;

import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class DivideProcedure implements Procedure {

    @Override
    public Object apply(List<Object> args, Environment env) {
        if (args.isEmpty()) {
            throw new RuntimeException("Empty list of arguments for /");
        }

        if (args.size() == 1) {
            if (!(args.get(0) instanceof Integer)) {
                throw new RuntimeException("Argument must be an integer");
            }
            int num = (Integer) args.get(0);
            if (num == 0) {
                throw new RuntimeException("Division by zero");
            }
            return 1.0 / num;
        }

        if (!(args.get(0) instanceof Integer)) {
            throw new RuntimeException("Invalid argument type for /: " + args.get(0));
        }
        int result = (Integer) args.get(0);

        for (int i = 1; i < args.size(); i++) {
            if (!(args.get(i) instanceof Integer)) {
                throw new RuntimeException("Invalid argument type for /: " + args.get(i));
            }
            int divisor = (Integer) args.get(i);
            if (divisor == 0) {
                throw new RuntimeException("Division by zero");
            }
            result /= divisor;
        }

        return result;
    }
}

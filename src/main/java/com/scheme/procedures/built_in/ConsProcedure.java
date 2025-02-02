package com.scheme.procedures.built_in;

import com.scheme.expression.Expression;
import com.scheme.expression.types.ListExpression;
import com.scheme.expression.types.LiteralExpression;
import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.ArrayList;
import java.util.List;

public class ConsProcedure implements Procedure {
    @Override
    public Object apply(List<Object> args, Environment env) {
        if (args.size() != 2) {
            throw new RuntimeException("cons requires exactly 2 arguments");
        }
        Object first = args.get(0);
        Object second = args.get(1);
        if (!(second instanceof ListExpression)) {
            throw new RuntimeException("cons second argument must be a list");
        }
        List<Expression> list = new ArrayList<>();
        list.add(new LiteralExpression(first));
        list.addAll(((ListExpression) second).getExpressions());
        return new ListExpression(list);
    }
}
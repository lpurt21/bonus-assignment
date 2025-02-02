package com.scheme.procedures.aritmetic;

import com.scheme.expression.Expression;
import com.scheme.expression.types.BooleanExpression;
import com.scheme.expression.types.ListExpression;
import com.scheme.expression.types.SymbolExpression;
import com.scheme.procedures.Procedure;
import com.scheme.utils.Environment;

import java.util.List;

public class EqualProcedure implements Procedure {
    @Override
    public Object apply(List<Object> args, Environment env) {
        if(args.size() != 2) throw new RuntimeException("equals requires two arguments");
        Object arg1 = args.get(0);
        Object arg2 = args.get(1);

        return areEqual(arg1, arg2, env);
    }

    private boolean areEqual(Object obj1, Object obj2, Environment env) {
        if (obj1 == null || obj2 == null) {
            return obj1 == obj2;
        }

        if (obj1 instanceof Number && obj2 instanceof Number) {
            return ((Number) obj1).doubleValue() == ((Number) obj2).doubleValue();
        }

        if (obj1 instanceof String && obj2 instanceof String) {
            return obj1.equals(obj2);
        }

        if (obj1 instanceof SymbolExpression && obj2 instanceof SymbolExpression) {
            return ((SymbolExpression) obj1).getName().equals(((SymbolExpression) obj2).getName());
        }

        if (obj1 instanceof ListExpression && obj2 instanceof ListExpression) {
            List<Expression> list1 = ((ListExpression) obj1).getExpressions();
            List<Expression> list2 = ((ListExpression) obj2).getExpressions();
            if (list1.size() != list2.size()) {
                return false;
            }
            for (int i = 0; i < list1.size(); i++) {
                if (!areEqual(list1.get(i).evaluate(env), list2.get(i).evaluate(env), env)) {
                    return false;
                }
            }
            return true;
        }
        if (obj1 instanceof BooleanExpression && obj2 instanceof BooleanExpression) {
            return ((BooleanExpression) obj1).evaluate(env).equals(((BooleanExpression) obj2).evaluate(env));
        }

        return obj1.equals(obj2);
    }
}

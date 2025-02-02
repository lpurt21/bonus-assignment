package com.scheme.interpreter;

import com.scheme.expression.Expression;
import com.scheme.procedures.aritmetic.*;
import com.scheme.procedures.built_in.*;
import com.scheme.utils.Environment;
import com.scheme.utils.Parser;
import com.scheme.utils.Tokenizer;

import java.util.ArrayList;
import java.util.List;

public class SchemeInterpreter {
    private final Environment globalEnv = new Environment();

    public SchemeInterpreter() {
        globalEnv.define("+", new AddProcedure());
        globalEnv.define("-", new MinusProcedure());
        globalEnv.define("*", new MultiplyProcedure());
        globalEnv.define("/", new DivideProcedure());
        globalEnv.define(">", new GreaterThanProcedure());
        globalEnv.define("<", new LessThanProcedure());
        globalEnv.define("car", new CarProcedure());
        globalEnv.define("cdr", new CdrProcedure());
        globalEnv.define("cons", new ConsProcedure());
        globalEnv.define("map", new MapProcedure());
        globalEnv.define("append", new AppendProcedure());
        globalEnv.define("null?", new NullProcedure());
        globalEnv.define("length", new LengthProcedure());
        globalEnv.define("apply", new ApplyProcedure());
        globalEnv.define("eval", new EvalProcedure());
        globalEnv.define("equal?", new EqualProcedure());
    }

    public Object interpret(String input) {
        List<String> tokens = Tokenizer.tokenize(input);
        Parser parser = new Parser(tokens);
        List<Expression> expressions = new ArrayList<>();
        while (parser.getPosition() < tokens.size()) {
            expressions.add(parser.parse());
        }

        Object result = null;
        for (Expression expr : expressions) {
            result = expr.evaluate(globalEnv);
        }
        return result;
    }
}

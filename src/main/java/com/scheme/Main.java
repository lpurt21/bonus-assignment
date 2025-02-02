package com.scheme;

import com.scheme.interpreter.SchemeInterpreter;
import com.scheme.utils.REPL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SchemeInterpreter interpreter = new SchemeInterpreter();
        REPL repl = new REPL(interpreter);
        repl.start();
    }
}
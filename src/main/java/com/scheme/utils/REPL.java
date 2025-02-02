package com.scheme.utils;

import com.scheme.interpreter.SchemeInterpreter;

import java.util.Scanner;

public class REPL {
    private final SchemeInterpreter schemeInterpreter;

    public REPL(SchemeInterpreter schemeInterpreter) {
        this.schemeInterpreter = schemeInterpreter;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Scheme Interpreter! Type 'exit' to quit.");

        while (true) {
            System.out.print(">> "); // Prompt for input
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                Object result = schemeInterpreter.interpret(input);
                if (result != null) {
                    System.out.println(result);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

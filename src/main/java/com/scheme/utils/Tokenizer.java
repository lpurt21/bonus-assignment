package com.scheme.utils;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {
    public static List<String> tokenize(String input) {
        return Arrays.asList(input.replace("(", " ( ").replace(")", " ) ").trim().split("\\s+"));
    }
}

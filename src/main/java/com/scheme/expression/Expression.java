package com.scheme.expression;

import com.scheme.utils.Environment;

public interface Expression {
    Object evaluate(Environment env);
}

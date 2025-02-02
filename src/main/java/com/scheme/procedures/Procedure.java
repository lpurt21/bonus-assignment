package com.scheme.procedures;

import com.scheme.utils.Environment;

import java.util.List;

public interface Procedure {
    Object apply (List<Object> args, Environment env);
}

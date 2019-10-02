package com.reedoei.imp.expression;

import com.reedoei.imp.Callable;
import com.reedoei.imp.Environment;
import com.reedoei.imp.value.Value;

import java.util.ArrayList;
import java.util.List;

public class CallExpr extends Expr {
    private final String name;
    private final List<Expr> arguments;

    public CallExpr(final String name, final List<Expr> arguments) {
        super();
        this.name = name;
        this.arguments = arguments;
    }

    @Override
    public Value evaluate(final Environment environment) {
        final Callable callable = environment.procedure(name)
                .orElseThrow(() -> new IllegalArgumentException("Unknown procedure: " + name));

        // We create a new arraylist to "cast" from Expr to Evaluatable
        return callable.call(environment, new ArrayList<>(arguments));
    }
}

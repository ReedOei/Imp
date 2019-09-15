package com.reedoei.imp;

public class VarExpr extends Expr {
    private final String name;

    public VarExpr(final String name) {
        super();
        this.name = name;
    }

    @Override
    public Value evaluate(final Environment environment) {
        return environment.var(name)
                .orElseThrow(() -> new IllegalArgumentException("Unknown variable: " + name));
    }
}

package com.reedoei.imp;

public abstract class Value extends Expr {
    @Override
    public Value evaluate(final Environment environment) {
        return this;
    }
}

package com.reedoei.imp;

import com.reedoei.imp.expression.Expr;

public abstract class Value extends Expr {
    @Override
    public Value evaluate(final Environment environment) {
        return this;
    }
}

package com.reedoei.imp.value;

import com.reedoei.imp.Environment;
import com.reedoei.imp.expression.Expr;

public abstract class Value extends Expr {
    @Override
    public Value evaluate(final Environment environment) {
        return this;
    }
}

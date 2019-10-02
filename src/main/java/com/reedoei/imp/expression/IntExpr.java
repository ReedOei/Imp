package com.reedoei.imp.expression;

import com.reedoei.imp.Environment;
import com.reedoei.imp.value.IntVal;

public class IntExpr extends Expr {
    private final int i;

    public IntExpr(final int i) {
        super();
        this.i = i;
    }

    public int i() {
        return i;
    }

    @Override
    public IntVal evaluate(final Environment environment) {
        return new IntVal(i());
    }

    @Override
    public String toString() {
        return "IntExpr{" +
                "i=" + i +
                '}';
    }
}

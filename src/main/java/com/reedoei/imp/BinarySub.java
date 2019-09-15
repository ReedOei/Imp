package com.reedoei.imp;

public class BinarySub extends BinaryExpr {
    public BinarySub(final Expr e1, final Expr e2) {
        super(e1, e2);
    }

    @Override
    public Value binaryOp(final int e1, final int e2) {
        return new IntVal(e1 - e2);
    }
}

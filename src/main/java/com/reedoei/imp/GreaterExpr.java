package com.reedoei.imp;

public class GreaterExpr extends BinaryExpr {
    public GreaterExpr(final Expr e1, final Expr e2) {
        super(e1, e2);
    }

    @Override
    public Value binaryOp(final int e1, final int e2) {
        return new BoolVal(e1 > e2);
    }
}

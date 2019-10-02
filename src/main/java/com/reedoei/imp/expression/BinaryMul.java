package com.reedoei.imp.expression;

import com.reedoei.imp.value.IntVal;

public class BinaryMul extends BinaryExpr {
    public BinaryMul(final Expr e1, final Expr e2) {
        super(e1, e2);
    }

    @Override
    public IntVal binaryOp(final int e1, final int e2) {
        return new IntVal(e1 * e2);
    }
}

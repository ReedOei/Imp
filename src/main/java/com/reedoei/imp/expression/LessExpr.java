package com.reedoei.imp.expression;

import com.reedoei.imp.value.BoolVal;
import com.reedoei.imp.value.Value;

public class LessExpr extends BinaryExpr {
    public LessExpr(final Expr e1, final Expr e2) {
        super(e1, e2);
    }

    @Override
    public Value binaryOp(final int e1, final int e2) {
        return new BoolVal(e1 < e2);
    }
}

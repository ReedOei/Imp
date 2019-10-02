package com.reedoei.imp.expression;

import com.reedoei.imp.value.BoolVal;
import com.reedoei.imp.Environment;
import com.reedoei.imp.value.Value;

public class NotExpr extends Expr {
    private final Expr e;

    public NotExpr(final Expr e) {
        super();
        this.e = e;
    }

    @Override
    public Value evaluate(final Environment environment) {
        final Value val = e.evaluate(environment);

        if (val instanceof BoolVal) {
            return new BoolVal(!((BoolVal) val).b());
        } else {
            throw new IllegalArgumentException("Operand must be a boolean!");
        }
    }
}

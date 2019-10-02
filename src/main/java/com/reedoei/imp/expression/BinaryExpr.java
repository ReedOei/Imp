package com.reedoei.imp.expression;

import com.reedoei.imp.Environment;
import com.reedoei.imp.value.IntVal;
import com.reedoei.imp.value.Value;

public abstract class BinaryExpr extends Expr {
    public static BinaryExpr from(final Expr e1, final String op, final Expr e2) {
        if (op.equals("+")) {
            return new BinaryAdd(e1, e2);
        } else if (op.equals("-")) {
            return new BinarySub(e1, e2);
        } else if (op.equals("*")) {
            return new BinaryMul(e1, e2);
        } else if (op.equals("/")) {
            return new BinaryDiv(e1, e2);
        } else {
            throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    private final Expr e1;
    private final Expr e2;

    public BinaryExpr(final Expr e1, final Expr e2) {

        this.e1 = e1;
        this.e2 = e2;
    }

    public Expr e1() {
        return e1;
    }

    public Expr e2() {
        return e2;
    }

    @Override
    public Value evaluate(final Environment environment) {
        final Value e1Val = e1().evaluate(environment);
        final Value e2Val = e2().evaluate(environment);

        if (e1Val instanceof IntVal && e2Val instanceof IntVal) {
            return binaryOp(((IntVal) e1Val).i(), ((IntVal) e2Val).i());
        } else {
            throw new IllegalArgumentException("Operands are not both integers!");
        }
    }

    public abstract Value binaryOp(final int e1, final int e2);
}

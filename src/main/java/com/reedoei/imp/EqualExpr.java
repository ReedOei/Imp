package com.reedoei.imp;

public class EqualExpr extends Expr {
    private final Expr e1;
    private final Expr e2;

    public EqualExpr(final Expr e1, final Expr e2) {
        super();
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public Value evaluate(final Environment environment) {
        return new BoolVal(e1.evaluate(environment).equals(e2.evaluate(environment)));
    }
}

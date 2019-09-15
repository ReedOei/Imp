package com.reedoei.imp;

public class Print extends Stmt {
    private final Expr expr;

    public Print(final Expr expr) {
        super();
        this.expr = expr;
    }

    @Override
    public void execute(final Environment environment) {
        System.out.println(expr.evaluate(environment).toString());
    }
}

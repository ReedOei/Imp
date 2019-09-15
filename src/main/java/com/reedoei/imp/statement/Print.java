package com.reedoei.imp.statement;

import com.reedoei.imp.Environment;
import com.reedoei.imp.expression.Expr;

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

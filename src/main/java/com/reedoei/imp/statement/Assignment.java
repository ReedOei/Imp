package com.reedoei.imp.statement;

import com.reedoei.imp.Environment;
import com.reedoei.imp.expression.Expr;

public class Assignment extends Stmt {
    private final String varName;
    private final Expr from;

    public Assignment(final String varName, final Expr from) {
        super();
        this.varName = varName;
        this.from = from;
    }

    @Override
    public void execute(final Environment environment) {
        environment.var(varName, from.evaluate(environment));
    }
}

package com.reedoei.imp.statement;

import com.reedoei.imp.BoolVal;
import com.reedoei.imp.Environment;
import com.reedoei.imp.Value;
import com.reedoei.imp.expression.Expr;

import java.util.List;

public class If extends Stmt {
    private final Expr cond;
    private final List<Stmt> thenBranch;
    private final List<Stmt> elseBranch;

    public If(final Expr cond, final List<Stmt> thenBranch, final List<Stmt> elseBranch) {
        super();
        this.cond = cond;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    @Override
    public void execute(final Environment environment) {
        final Value evaluate = cond.evaluate(environment);

        if (evaluate instanceof BoolVal) {
            if (((BoolVal) evaluate).b()) {
                for (final Stmt stmt : thenBranch) {
                    stmt.execute(environment);
                }
            } else {
                for (final Stmt stmt : elseBranch) {
                    stmt.execute(environment);
                }
            }
        } else {
            throw new IllegalArgumentException("Conditions must be booleans!");
        }
    }
}

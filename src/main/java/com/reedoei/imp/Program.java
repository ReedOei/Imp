package com.reedoei.imp;

import com.reedoei.imp.expr.ExprParser;
import com.reedoei.imp.statement.Stmt;

import java.util.List;
import java.util.stream.Collectors;

public class Program implements Executable {
    private final List<Stmt> stmts;

    public Program(final List<Stmt> stmts) {
        this.stmts = stmts;
    }

    public static Program from(final ExprParser.ProgContext progContext) {
        return new Program(progContext.stmt().stream().map(Stmt::from).collect(Collectors.toList()));
    }

    @Override
    public void execute(final Environment environment) {
        for (final Stmt stmt : stmts) {
            stmt.execute(environment);
        }
    }
}

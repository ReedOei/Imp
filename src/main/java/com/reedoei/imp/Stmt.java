package com.reedoei.imp;

import com.reedoei.imp.expr.ExprParser;

import java.util.stream.Collectors;

public abstract class Stmt implements Executable {
    public static Stmt from(final ExprParser.StmtContext stmt) {
        if (stmt instanceof ExprParser.AssignContext) {
            final ExprParser.AssignContext assign = (ExprParser.AssignContext) stmt;
            return new Assignment(assign.ID().getSymbol().getText(), Expr.from(assign.expr()));
        } else if (stmt instanceof ExprParser.PrintContext){
            final ExprParser.PrintContext print = (ExprParser.PrintContext) stmt;
            return new Print(Expr.from(print.expr()));
        } else if (stmt instanceof ExprParser.ProcedureContext) {
            final ExprParser.ProcedureContext proc = (ExprParser.ProcedureContext) stmt;
            return new Procedure(
                    proc.ID().getSymbol().getText(),
                    proc.args().ID().stream().map(node -> node.getSymbol().getText()).collect(Collectors.toList()),
                    proc.body().stmt().stream().map(Stmt::from).collect(Collectors.toList()),
                    Expr.from(proc.expr()));
        } else if (stmt instanceof ExprParser.IfContext) {
            final ExprParser.IfContext ifStmt = (ExprParser.IfContext) stmt;
            return new If(
                    Expr.from(ifStmt.expr()),
                    ifStmt.body(0).stmt().stream().map(Stmt::from).collect(Collectors.toList()),
                    ifStmt.body(1).stmt().stream().map(Stmt::from).collect(Collectors.toList()));
        } else {
                throw new IllegalArgumentException("Unkown type of statement!");
        }
    }
}

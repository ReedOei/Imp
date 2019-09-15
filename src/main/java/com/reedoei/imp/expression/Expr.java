package com.reedoei.imp.expression;

import com.reedoei.imp.Evaluatable;
import com.reedoei.imp.expr.ExprParser;

import java.util.stream.Collectors;

public abstract class Expr implements Evaluatable {
    public static Expr from(final ExprParser.ExprContext expr) {
        if (expr instanceof ExprParser.BinaryOpContext) {
            final ExprParser.BinaryOpContext binOp = (ExprParser.BinaryOpContext) expr;
            return BinaryExpr.from(from(binOp.expr(0)), expr.children.get(1).getText(), from(binOp.expr(1)));
        } else if (expr instanceof ExprParser.ParenContext) {
            final ExprParser.ParenContext paren = (ExprParser.ParenContext) expr;
            return from(paren.expr());
        } else if (expr instanceof ExprParser.ConstantContext) {
            final ExprParser.ConstantContext constant = (ExprParser.ConstantContext) expr;
            return new IntExpr(Integer.parseInt(constant.INT().getSymbol().getText()));
        } else if (expr instanceof ExprParser.CallContext) {
            final ExprParser.CallContext call = (ExprParser.CallContext) expr;
            return new CallExpr(call.ID().getSymbol().getText(),
                    call.expr().stream().map(Expr::from).collect(Collectors.toList()));
        } else if (expr instanceof ExprParser.VarContext) {
            final ExprParser.VarContext varExpr = (ExprParser.VarContext) expr;
            return new VarExpr(varExpr.ID().getSymbol().getText());
        } else if (expr instanceof ExprParser.EqualContext) {
            final ExprParser.EqualContext equal = (ExprParser.EqualContext) expr;
            return new EqualExpr(from(equal.expr(0)), from(equal.expr(1)));
        } else if (expr instanceof ExprParser.LessContext) {
            final ExprParser.LessContext less = (ExprParser.LessContext) expr;
            return new LessExpr(from(less.expr(0)), from(less.expr(1)));
        } else if (expr instanceof ExprParser.NotContext) {
            final ExprParser.NotContext not = (ExprParser.NotContext) expr;
            return new NotExpr(from(not.expr()));
        } else if (expr instanceof ExprParser.GreaterContext) {
            final ExprParser.GreaterContext greater = (ExprParser.GreaterContext) expr;
            return new GreaterExpr(from(greater.expr(0)), from(greater.expr(1)));
        }

        throw new IllegalArgumentException("Unknown kind of expression");
    }
}

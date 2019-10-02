package com.reedoei.imp.statement;

import com.reedoei.imp.Callable;
import com.reedoei.imp.Environment;
import com.reedoei.imp.Evaluatable;
import com.reedoei.imp.expression.Expr;
import com.reedoei.imp.statement.Stmt;
import com.reedoei.imp.value.Value;

import java.util.List;

public class Procedure extends Stmt implements Callable {
    private final String name;
    private final List<String> argNames;
    private final List<Stmt> body;
    private final Expr from;

    public Procedure(final String name, final List<String> argNames, final List<Stmt> body, final Expr from) {
        super();
        this.name = name;
        this.argNames = argNames;
        this.body = body;
        this.from = from;
    }

    @Override
    public void execute(final Environment environment) {
        environment.procedure(name, this);
    }

    @Override
    public Value call(final Environment environment, final List<Evaluatable> arguments) {
        if (arguments.size() != argNames.size()) {
            throw new IllegalArgumentException("Got " + arguments.size() + " arguments to " + name + ". Expected: " + argNames.size());
        }

        return environment.executeInNewEnv(env -> {
            for (int i = 0; i < arguments.size(); i++) {
                env.var(argNames.get(i), arguments.get(i).evaluate(env));
            }

            for (final Stmt stmt : body) {
                stmt.execute(env);
            }

            return from.evaluate(env);
        });
    }
}

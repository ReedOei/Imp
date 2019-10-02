package com.reedoei.imp;

import com.reedoei.imp.value.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class Environment {
    private final Map<String, Value> vars;
    private final Map<String, Callable> procedures;

    public Environment() {
        this.vars = new HashMap<>();
        this.procedures = new HashMap<>();
    }

    public Environment(final Map<String, Value> vars, final Map<String, Callable> procedures) {
        this.vars = vars;
        this.procedures = procedures;
    }

    public Optional<Value> var(final String varName) {
        return Optional.ofNullable(vars.get(varName));
    }

    public void var(final String varName, final Value varVal) {
        vars.put(varName, varVal);
    }

    public Optional<Callable> procedure(final String procName) {
        return Optional.ofNullable(procedures.get(procName));
    }

    public void procedure(final String procName, final Callable proc) {
        procedures.put(procName, proc);
    }

    public <T> T executeInNewEnv(final Function<Environment, T> toExecute) {
        return toExecute.apply(new Environment(new HashMap<>(this.vars), procedures));
    }
}

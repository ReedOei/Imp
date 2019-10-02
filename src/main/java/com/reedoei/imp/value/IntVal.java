package com.reedoei.imp.value;

import java.util.Objects;

public class IntVal extends Value {
    private final int i;

    public IntVal(final int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final IntVal intVal = (IntVal) o;
        return i == intVal.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }

    public int i() {
        return i;
    }
}

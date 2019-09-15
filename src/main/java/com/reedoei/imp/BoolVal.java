package com.reedoei.imp;

import java.util.Objects;

public class BoolVal extends Value {
    private final boolean b;

    public BoolVal(final boolean b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "BoolVal{" +
                "b=" + b +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BoolVal boolVal = (BoolVal) o;
        return b == boolVal.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(b);
    }

    public boolean b() {
        return b;
    }
}

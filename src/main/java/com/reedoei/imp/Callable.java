package com.reedoei.imp;

import com.reedoei.imp.value.Value;

import java.util.List;

public interface Callable {
    Value call(final Environment environment, final List<Evaluatable> arguments);
}

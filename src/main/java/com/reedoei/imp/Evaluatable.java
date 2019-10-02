package com.reedoei.imp;

import com.reedoei.imp.value.Value;

public interface Evaluatable {
    Value evaluate(final Environment environment);
}

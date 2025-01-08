package org.boyerfamily.sudoku;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toMap;

public enum Value {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);

    private static final Map<Integer, Value> ENUM_MAP;

    static {
        ENUM_MAP = Stream.of(Value.values()).collect(toMap(Value::getVal, identity()));
    }

    private final Integer val;

    Value(Integer i) {
        this.val = i;
    }

    public static Value fromInt(Integer i) {
        if (i == 0) {
            return null;
        }

        return ENUM_MAP.get(i);
    }

    public Integer getVal() {
        return this.val;
    }

    @Override
    public String toString() {
        return this.val.toString();
    }
}

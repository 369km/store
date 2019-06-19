package com.fudo.store.util;

import java.math.BigDecimal;
import java.util.Objects;

public class NumberUtil {
    public static Long nullToLong(Long l) {
        return Objects.isNull(l) ? 0L : l;
    }

    public static BigDecimal nullToDecimal(BigDecimal b) {
        return Objects.isNull(b) ? BigDecimal.ZERO : b;
    }
}

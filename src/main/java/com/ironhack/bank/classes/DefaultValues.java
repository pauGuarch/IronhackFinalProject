package com.ironhack.bank.classes;

import java.math.BigDecimal;

public class DefaultValues {
    private DefaultValues() {
        // No need to instantiate the class, we can hide its constructor
    }

    public static final BigDecimal penaltyFee = BigDecimal.valueOf(40.00);
}

package org.example;

public class CashCommissionCreator extends CommissionCreator {

    @Override
    public CommissionStrategy createCommission() {
        return new CashCommission();
    }
}
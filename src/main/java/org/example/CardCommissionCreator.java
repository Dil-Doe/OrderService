package org.example;

public class CardCommissionCreator extends CommissionCreator {

    @Override
    public CommissionStrategy createCommission() {
        return new CardCommission();
    }
}
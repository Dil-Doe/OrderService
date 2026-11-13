package org.example;

public class TransferCommissionCreator extends CommissionCreator {

    @Override
    public CommissionStrategy createCommission() {
        return new TransferCommission();
    }
}
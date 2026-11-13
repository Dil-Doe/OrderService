package org.example;

public class CashCommission implements CommissionStrategy {

    @Override
    public double calculateCommission(double amount) {
        return 0.0;
    }
}
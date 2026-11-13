package org.example;

public class CardCommission implements CommissionStrategy {

    @Override
    public double calculateCommission(double amount) {
        return amount * 0.02;
    }
}
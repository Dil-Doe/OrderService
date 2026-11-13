package org.example;

public class TransferCommission implements CommissionStrategy {

    @Override
    public double calculateCommission(double amount) {
        return amount * 0.01;
    }
}
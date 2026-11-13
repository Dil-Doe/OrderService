package org.example;

public class PremiumDiscountCreator extends DiscountCreator {

    @Override
    public DiscountStrategy createDiscount() {
        return new PremiumDiscount();
    }
}
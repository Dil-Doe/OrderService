package org.example;

public class RegularDiscountCreator extends DiscountCreator {

    @Override
    public DiscountStrategy createDiscount() {
        return new RegularDiscount();
    }
}
package org.example;

public class VipDiscountCreator extends DiscountCreator {

    @Override
    public DiscountStrategy createDiscount() {
        return new VipDiscount();
    }
}
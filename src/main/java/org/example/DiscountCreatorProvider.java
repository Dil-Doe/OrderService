package org.example;

public interface DiscountCreatorProvider {
    DiscountCreator selectCreator(String customerType);
}
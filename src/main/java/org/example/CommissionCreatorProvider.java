package org.example;

public interface CommissionCreatorProvider {
    CommissionCreator selectCreator(String paymentType);
}
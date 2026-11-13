package org.example;

import java.util.Map;

public class CommissionSelector implements CommissionCreatorProvider {

    private final Map<String, CommissionCreator> creators = Map.of(
            "CARD", new CardCommissionCreator(),
            "CASH", new CashCommissionCreator(),
            "TRANSFER", new TransferCommissionCreator()
    );

    @Override
    public CommissionCreator selectCreator(String paymentType) {
        CommissionCreator creator = creators.get(paymentType);

        if (creator == null) {
            throw new RuntimeException("Unknown payment type: " + paymentType);
        }

        return creator;
    }
}
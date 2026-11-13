package org.example;

import java.util.Map;

public class DiscountSelector implements DiscountCreatorProvider {

    private final Map<String, DiscountCreator> creators = Map.of(
            "REGULAR", new RegularDiscountCreator(),
            "VIP", new VipDiscountCreator(),
            "PREMIUM", new PremiumDiscountCreator()
    );

    @Override
    public DiscountCreator selectCreator(String customerType) {
        DiscountCreator creator = creators.get(customerType);

        if (creator == null) {
            throw new RuntimeException("Unknown customer type: " + customerType);
        }

        return creator;
    }
}
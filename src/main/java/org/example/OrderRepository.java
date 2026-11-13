package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements OrderStorage {

    private final List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        orders.add(order);
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }
}
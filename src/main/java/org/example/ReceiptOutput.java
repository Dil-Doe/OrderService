package org.example;

public interface ReceiptOutput {
    void printReceipt(Order order, double discount, double commission, double finalAmount);
}
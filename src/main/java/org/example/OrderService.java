package org.example;

/**
 * Контекст: Тебе достался в наследство код от предыдущего разработчика — сервис обработки заказов интернет-магазина OrderService.
 * Он работает, тесты (если бы они были) прошли бы, заказчик доволен... пока не попросил добавить новый тип клиента или способ оплаты.
 * Тут выясняется, что каждое такое "простое" изменение требует лезть в один и тот же метод на 80 строк, где всё завязано друг на друга,
 * и есть риск что-то сломать в соседней логике.
 * Твоя задача: не переписать сервис с нуля, а отрефакторить — сохранив то же поведение (те же скидки, та же комиссия, тот же чек)
 * Опирайся на SOLID и паттерны проектирования
 * Lombok использовать нельзя, все писать руками.
 */
public class OrderService {

    private final OrderValidation validator;
    private final ReceiptOutput receiptPrinter;
    private final OrderStorage repository;
    private final DiscountCreatorProvider discountCreatorProvider;
    private final CommissionCreatorProvider commissionCreatorProvider;

    public OrderService(OrderValidation validator, ReceiptOutput receiptPrinter, OrderStorage repository,
                        DiscountCreatorProvider discountCreatorProvider,
                        CommissionCreatorProvider commissionCreatorProvider) {
        this.validator = validator;
        this.receiptPrinter = receiptPrinter;
        this.repository = repository;
        this.discountCreatorProvider = discountCreatorProvider;
        this.commissionCreatorProvider = commissionCreatorProvider;
    }

    public double processOrder(Order order) {

        // --- валидация ---
        validator.validate(order);

        // --- расчёт скидки по типу клиента ---
        DiscountCreator discountCreator = discountCreatorProvider.selectCreator(order.getCustomerType());
        DiscountStrategy discountStrategy = discountCreator.createDiscount();
        double discount = discountStrategy.calculateDiscount(order.getAmount());

        // --- расчёт комиссии по способу оплаты ---
        CommissionCreator commissionCreator = commissionCreatorProvider.selectCreator(order.getPaymentType());
        CommissionStrategy commissionStrategy = commissionCreator.createCommission();
        double commission = commissionStrategy.calculateCommission(order.getAmount());

        // --- итоговая сумма ---
        double finalAmount = order.getAmount() - discount + commission;

        // --- печать чека ---
        receiptPrinter.printReceipt(order, discount, commission, finalAmount);

        // --- "сохранение" заказа ---
        repository.save(order);

        return finalAmount;
    }
}


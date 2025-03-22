package dev.srivatsan.strategy;

public class GPayPayment implements PaymentStrategy {
    private String userId;

    public GPayPayment(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using GPay for user: " + userId);
        return true;
    }
}
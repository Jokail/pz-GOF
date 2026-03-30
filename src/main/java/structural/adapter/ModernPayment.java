package structural.adapter;

public interface ModernPayment {

    void processPayment(String orderId, double amount, String currency);

    boolean isServiceAvailable();
}

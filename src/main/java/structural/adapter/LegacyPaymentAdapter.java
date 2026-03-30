package structural.adapter;

public class LegacyPaymentAdapter implements ModernPayment {

    private final LegacyPaymentSystem legacySystem;

    public LegacyPaymentAdapter(LegacyPaymentSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void processPayment(String orderId, double amount, String currency) {
        int orderNumber = parseOrderNumber(orderId);
        int amountKopecks = (int) Math.round(amount * 100);

        System.out.printf("[Adapter] Конвертація: orderId='%s'→%d, %.2f %s→%d коп.%n",
                orderId, orderNumber, amount, currency, amountKopecks);

        legacySystem.executeTransaction(orderNumber, amountKopecks);
    }

    @Override
    public boolean isServiceAvailable() {
        return "OK".equals(legacySystem.ping());
    }

    private int parseOrderNumber(String orderId) {
        return Integer.parseInt(orderId.replaceAll("[^0-9]", ""));
    }
}

package structural.adapter;

public class AdapterDemo {

    public static void run() {
        System.out.println("═══════════════════════════════════════");
        System.out.println("   ADAPTER — Структурний патерн");
        System.out.println("═══════════════════════════════════════");

        LegacyPaymentSystem oldSystem = new LegacyPaymentSystem();

        ModernPayment payment = new LegacyPaymentAdapter(oldSystem);

        System.out.println("[Adapter] Сервіс доступний: " + payment.isServiceAvailable());
        payment.processPayment("ORD-4217", 1299.99, "UAH");
        payment.processPayment("ORD-0001", 50.00,   "UAH");
        System.out.println();
        System.out.println("Висновок: Adapter дозволяє використовувати несумісний");
        System.out.println("         legacy-інтерфейс без зміни його коду.");
        System.out.println();
    }
}

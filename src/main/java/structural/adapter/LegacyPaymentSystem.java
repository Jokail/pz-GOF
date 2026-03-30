package structural.adapter;

public class LegacyPaymentSystem {

    public void executeTransaction(int orderNumber, int amountKopecks) {
        System.out.printf("[LegacyPayment] Транзакція виконана: замовлення №%d, сума %d коп. (%.2f грн)%n",
                orderNumber, amountKopecks, amountKopecks / 100.0);
    }

    public String ping() {
        return "OK";
    }
}

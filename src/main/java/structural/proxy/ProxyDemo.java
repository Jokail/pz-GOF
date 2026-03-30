package structural.proxy;

public class ProxyDemo {

    public static void run() {
        System.out.println("═══════════════════════════════════════");
        System.out.println("   PROXY (Protection) — Структурний патерн");
        System.out.println("═══════════════════════════════════════");

        RealImage file = new RealImage("звіт.pdf", "Фінансовий звіт 2024");

        Image userAccess  = new ProxyImage(file, "Олексій", ProxyImage.Role.USER);
        Image adminAccess = new ProxyImage(file, "Марія",   ProxyImage.Role.ADMIN);

        System.out.println("\n-- Олексій (USER) --");
        userAccess.view();
        userAccess.edit("змінений текст");
        userAccess.delete();

        System.out.println("\n-- Марія (ADMIN) --");
        adminAccess.view();
        adminAccess.edit("Оновлений звіт 2025");
        adminAccess.delete();

        System.out.println();
        System.out.println("Висновок: Proxy перевіряє права доступу перед делегуванням до реального об'єкта.");
        System.out.println();
    }
}

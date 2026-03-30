package behavioral.observer;

public class ObserverDemo {

    public static void run() {
        System.out.println("═══════════════════════════════════════");
        System.out.println("   OBSERVER — Поведінковий патерн");
        System.out.println("═══════════════════════════════════════");

        NewsAgency agency = new NewsAgency("УкрІнфо");

        MobileAppSubscriber mobileUser1 = new MobileAppSubscriber("Телефон Олексія");
        MobileAppSubscriber mobileUser2 = new MobileAppSubscriber("Планшет Марії");
        EmailSubscriber     emailUser   = new EmailSubscriber("admin@example.com");

        agency.subscribe(mobileUser1);
        agency.subscribe(mobileUser2);
        agency.subscribe(emailUser);

        agency.publishBreakingNews("Новий рекорд індексу ПФТС!");
        agency.publishUpdate("Курс долара: 41.20 грн");

        System.out.println();
        agency.unsubscribe(mobileUser2);
        agency.publishBreakingNews("НБУ знизив облікову ставку до 13%");

        System.out.println();
        System.out.printf("[ObserverDemo] Олексій отримав %d сповіщень, Марія — %d.%n",
                mobileUser1.getNotificationCount(), mobileUser2.getNotificationCount());
        System.out.println();
    }
}

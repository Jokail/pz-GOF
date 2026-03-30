package creational.singleton;

public class SingletonDemo {

    public static void run() {

        AppLogger logger1 = AppLogger.getInstance();
        logger1.info("Додаток запущено");
        logger1.info("Завантаження конфігурації...");

        AppLogger logger2 = AppLogger.getInstance();
        logger2.warn("Диск заповнено на 90%");
        logger2.error("З'єднання з БД перервано");

        System.out.println();
        System.out.println("[Singleton] logger1 == logger2 : " + (logger1 == logger2));
        System.out.println("[Singleton] Всього записів у логі: " + logger1.getLogCount());
        System.out.println();
    }
}

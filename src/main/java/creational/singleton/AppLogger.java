package creational.singleton;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppLogger {

    private static volatile AppLogger instance;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private int logCount = 0;

    private AppLogger() {
        System.out.println("[AppLogger] Єдиний екземпляр логера створено.");
    }

    public static AppLogger getInstance() {
        if (instance == null) {
            synchronized (AppLogger.class) {
                if (instance == null) {
                    instance = new AppLogger();
                }
            }
        }
        return instance;
    }

    public void info(String message) {
        log("INFO ", message);
    }

    public void warn(String message) {
        log("WARN ", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    private void log(String level, String message) {
        logCount++;
        String time = LocalTime.now().format(formatter);
        System.out.printf("[%s] [%s] #%03d  %s%n", time, level, logCount, message);
    }

    public int getLogCount() {
        return logCount;
    }
}

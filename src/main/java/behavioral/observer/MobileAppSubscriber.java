package behavioral.observer;

public class MobileAppSubscriber implements Observer {

    private final String appName;
    private int notificationCount;

    public MobileAppSubscriber(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String eventType, String data) {
        notificationCount++;
        String icon = eventType.equals("BREAKING") ? "🔔" : "📰";
        System.out.printf("  [%s] %s Push #%d: [%s] %s%n",
                appName, icon, notificationCount, eventType, data);
    }

    public int getNotificationCount() {
        return notificationCount;
    }
}

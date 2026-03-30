package behavioral.observer;

public class EmailSubscriber implements Observer {

    private final String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, String data) {
        if ("BREAKING".equals(eventType)) {
            System.out.printf("  [Email → %s] Надіслано термінову новину: \"%s\"%n", email, data);
        }
    }
}

package structural.proxy;

public class ProxyImage implements Image {

    public enum Role { USER, ADMIN }

    private final RealImage realImage;
    private final String    username;
    private final Role      role;

    public ProxyImage(RealImage realImage, String username, Role role) {
        this.realImage = realImage;
        this.username  = username;
        this.role      = role;
    }

    @Override
    public void view() {
        // переглядати може будь-хто
        System.out.printf("[Proxy] %s переглядає файл.%n", username);
        realImage.view();
    }

    @Override
    public void edit(String newContent) {
        // редагувати може тільки ADMIN
        if (role != Role.ADMIN) {
            System.out.printf("[Proxy] ЗАБОРОНЕНО: %s (USER) не може редагувати.%n", username);
            return;
        }
        System.out.printf("[Proxy] %s (ADMIN) редагує файл.%n", username);
        realImage.edit(newContent);
    }

    @Override
    public void delete() {
        // видаляти може тільки ADMIN
        if (role != Role.ADMIN) {
            System.out.printf("[Proxy] ЗАБОРОНЕНО: %s (USER) не може видаляти.%n", username);
            return;
        }
        System.out.printf("[Proxy] %s (ADMIN) видаляє файл.%n", username);
        realImage.delete();
    }
}

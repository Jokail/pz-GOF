package structural.proxy;

public class RealImage implements Image {

    private final String filename;
    private String content;

    public RealImage(String filename, String content) {
        this.filename = filename;
        this.content  = content;
    }

    @Override
    public void view() {
        System.out.printf("[RealImage] Перегляд '%s': %s%n", filename, content);
    }

    @Override
    public void edit(String newContent) {
        this.content = newContent;
        System.out.printf("[RealImage] '%s' відредаговано. Новий вміст: %s%n", filename, content);
    }

    @Override
    public void delete() {
        System.out.printf("[RealImage] '%s' видалено.%n", filename);
    }
}

package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {

    private final String name;
    private final List<Observer> observers = new ArrayList<>();
    private String latestHeadline;

    public NewsAgency(String name) {
        this.name = name;
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
        System.out.printf("[%s] Новий підписник додано. Всього: %d%n", name, observers.size());
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
        System.out.printf("[%s] Підписник відписався. Залишилось: %d%n", name, observers.size());
    }

    public void publishBreakingNews(String headline) {
        this.latestHeadline = headline;
        System.out.printf("%n[%s] *** ТЕРМІНОВА НОВИНА: %s ***%n", name, headline);
        notifyAll("BREAKING", headline);
    }

    public void publishUpdate(String update) {
        System.out.printf("[%s] Оновлення: %s%n", name, update);
        notifyAll("UPDATE", update);
    }

    private void notifyAll(String eventType, String data) {
        for (Observer observer : observers) {
            observer.update(eventType, data);
        }
    }

    public String getLatestHeadline() {
        return latestHeadline;
    }
}

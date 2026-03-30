package behavioral.strategy;

import java.util.Arrays;

public class Sorter {

    private SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        System.out.printf("[Sorter] Алгоритм: %-22s  вхід: %s%n",
                strategy.getName(), Arrays.toString(copy));
        strategy.sort(copy);
        System.out.printf("[Sorter] %-30s результат: %s%n", "", Arrays.toString(copy));
        return copy;
    }
}

package behavioral.strategy;

public class StrategyDemo {

    public static void run() {
        System.out.println("═══════════════════════════════════════");
        System.out.println("   STRATEGY — Поведінковий патерн");
        System.out.println("═══════════════════════════════════════");

        int[] data = {64, 34, 25, 12, 22, 11, 90};

        Sorter sorter = new Sorter(new BubbleSortStrategy());
        sorter.sort(data);

        sorter.setStrategy(new QuickSortStrategy());
        sorter.sort(data);

        System.out.println();
        System.out.println("Висновок: Strategy дозволяє підміняти алгоритми");
        System.out.println("         під час виконання без зміни коду Context.");
        System.out.println();
    }
}

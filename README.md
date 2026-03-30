# Practical lesson pz-GOF
# Реалізація GOF патернів проєктування (Java)

> Практична реалізація 6 класичних GoF-патернів проєктування на мові **Java**.
> Мета — навчитися застосовувати породжувальні, структурні та поведінкові патерни для покращення архітектури програмних рішень.

---

## Реалізовані патерни

### Породжувальні (Creational)

| Патерн | Проблема | Рішення |
|---|---|---|
| **Builder** | Конструктор з 5+ аргументами незручний і схильний до помилок | Покрокова побудова об'єкта через fluent API |
| **Singleton** | Кожен модуль створює власний логер — дублювання стану | Єдиний екземпляр через приватний конструктор + double-checked locking |

### Структурні (Structural)

| Патерн | Проблема | Рішення |
|---|---|---|
| **Adapter** | Стара платіжна система має несумісний API (int копійки vs double гривні) | Клас-адаптер перетворює виклики без зміни legacy-коду |
| **Proxy** | Завантаження всіх зображень одразу — повільний старт | Virtual Proxy відкладає завантаження до першого реального запиту |

### Поведінкові (Behavioral)

| Патерн | Проблема | Рішення |
|---|---|---|
| **Strategy** | Алгоритми сортування захардкоджені всередині класу через if/else | Кожен алгоритм — окремий клас; підміна «на льоту» без зміни Context |
| **Observer** | Пряма залежність між агентством і підписниками — погана зв'язність | Subject сповіщає підписників через інтерфейс; вільне підписування/відписування |

---

## Структура проєкту

```
pz-GOF/
├── pom.xml
└── src/
    └── main/
        └── java/
            ├── Main.java                          ← запуск усіх демо
            ├── creational/
            │   ├── builder/
            │   │   ├── Computer.java              ← продукт + вкладений Builder
            │   │   └── BuilderDemo.java
            │   └── singleton/
            │       ├── AppLogger.java             ← thread-safe логер
            │       └── SingletonDemo.java
            ├── structural/
            │   ├── adapter/
            │   │   ├── ModernPayment.java         ← Target інтерфейс
            │   │   ├── LegacyPaymentSystem.java   ← Adaptee
            │   │   ├── LegacyPaymentAdapter.java  ← Adapter
            │   │   └── AdapterDemo.java
            │   └── proxy/
            │       ├── Image.java                 ← Subject інтерфейс
            │       ├── RealImage.java             ← Real Subject
            │       ├── ProxyImage.java            ← Virtual Proxy
            │       └── ProxyDemo.java
            └── behavioral/
                ├── strategy/
                │   ├── SortStrategy.java          ← Strategy інтерфейс
                │   ├── BubbleSortStrategy.java    ← Concrete Strategy
                │   ├── QuickSortStrategy.java     ← Concrete Strategy
                │   ├── Sorter.java                ← Context
                │   └── StrategyDemo.java
                └── observer/
                    ├── Observer.java              ← Observer інтерфейс
                    ├── NewsAgency.java            ← Concrete Subject
                    ├── MobileAppSubscriber.java   ← Concrete Observer
                    ├── EmailSubscriber.java       ← Concrete Observer
                    └── ObserverDemo.java
```

---

## Запуск проєкту

### З Maven

```bash
mvn compile
mvn exec:java -Dexec.mainClass="Main"
```

### З javac напряму

```bash
cd src/main/java

# Компіляція
javac -encoding UTF-8 \
  creational/builder/Computer.java creational/builder/BuilderDemo.java \
  creational/singleton/AppLogger.java creational/singleton/SingletonDemo.java \
  structural/adapter/ModernPayment.java structural/adapter/LegacyPaymentSystem.java \
  structural/adapter/LegacyPaymentAdapter.java structural/adapter/AdapterDemo.java \
  structural/proxy/Image.java structural/proxy/RealImage.java \
  structural/proxy/ProxyImage.java structural/proxy/ProxyDemo.java \
  behavioral/strategy/SortStrategy.java behavioral/strategy/BubbleSortStrategy.java \
  behavioral/strategy/QuickSortStrategy.java behavioral/strategy/Sorter.java \
  behavioral/strategy/StrategyDemo.java \
  behavioral/observer/Observer.java behavioral/observer/NewsAgency.java \
  behavioral/observer/MobileAppSubscriber.java behavioral/observer/EmailSubscriber.java \
  behavioral/observer/ObserverDemo.java \
  Main.java

# Запуск
java Main
```

---

## Очікуваний вивід (фрагмент)

```
╔═══════════════════════════════════════╗
║   GoF Design Patterns — Java Demo     ║
╚═══════════════════════════════════════╝

═══════════════════════════════════════
   BUILDER — Породжувальний патерн
═══════════════════════════════════════
[Builder] Ігровий ПК:  Computer { CPU='Intel i9-14900K', RAM='64GB DDR5', ... }
[Builder] Офісний ПК:  Computer { CPU='Intel i5-13400', RAM='16GB DDR4', GPU='Integrated', ... }

═══════════════════════════════════════
   SINGLETON — Породжувальний патерн
═══════════════════════════════════════
[AppLogger] Єдиний екземпляр логера створено.
[Singleton] logger1 == logger2 : true

...

╔═══════════════════════════════════════╗
║            Демонстрацію завершено     ║
╚═══════════════════════════════════════╝
```

---

## Короткі висновки

- **Builder** усуває «телескопічні» конструктори: кожен параметр іменований, необов'язкові — пропускаються.
- **Singleton** з double-checked locking гарантує єдиний потокобезпечний екземпляр без зайвої синхронізації.
- **Adapter** дозволяє інтегрувати несумісні API без зміни вихідного коду будь-якої зі сторін.
- **Proxy** (virtual) відкладає створення важкого об'єкта до першого реального звернення, кешуючи результат.
- **Strategy** замінює розгалуження if/else ієрархією класів; алгоритм стає взаємозамінним артефактом.
- **Observer** реалізує слабку зв'язність між джерелом подій та реагуючими на них об'єктами через єдиний інтерфейс.

---

## Корисні посилання

- [Refactoring Guru — Патерни проєктування](https://refactoring.guru/uk/design-patterns)
- [Gang of Four (GoF) Patterns Overview](https://www.digitalocean.com/community/tutorials/gangs-of-four-gof-design-patterns)
- [Head First Design Patterns (book)](https://www.oreilly.com/library/view/head-first-design/0596007124/)
- [Ти мусиш знати ці патерни проєктування!](https://www.youtube.com/watch?v=Dc6AEjHvpP8)

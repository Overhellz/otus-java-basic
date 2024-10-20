package com.rodiond26.overhellz.otus.basic.lesson28.lection;

/**
 * Использование синхронизации с помощью мониторов для управления доступом к общим ресурсам в многопоточном окружении
 */
public class Example6 {

    /**
     * c1 и c2 — это два целочисленных счетчика, которые изменяются в разных потоках.
     */
    private int c1 = 0;
    private int c2 = 0;

    /**
     * mon1 и mon2 — это объекты-мониторы, используемые для синхронизации операций над счетчиками c1 и c2.
     */
    private final Object mon1 = new Object();
    private final Object mon2 = new Object();

    /**
     * В методе main() создается объект Main с начальными значениями c1 = 1000 и c2 = 1000.
     * Далее создаются два потока:
     * Первый поток (thread1) миллион раз увеличивает значение c1 с помощью метода inc1().
     * Второй поток (thread2) миллион раз уменьшает значение c1 с помощью метода dec1().
     * После запуска потоков, основной поток вызывает метод join(), чтобы дождаться завершения обоих потоков перед тем,
     * как вывести итоговые значения счетчиков c1 и c2.
     * <p>
     * Вывод: Методы inc1() и dec1() синхронизируются на объекте mon1, что предотвращает одновременный доступ
     * к счетчику c1 двумя потоками.
     * Гарантированная последовательность операций: Благодаря синхронизации, операции увеличения
     * и уменьшения переменной c1 происходят последовательно, что предотвращает возможные ошибки,
     * связанные с параллельной работой потоков.
     * Если мы уберем критические секции из методов, то код сразу будет работать не правильно!
     */
    public static void main(String[] args) throws InterruptedException {
        Example6 main = new Example6(1000, 1000);

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            for (int i = 0; i < 1000000; i++) { // 1 млн раз +
                main.inc1();
            }
            System.out.println(Thread.currentThread().getName() + " end");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            for (int i = 0; i < 1000000; i++) { // 1 млн раз -
                main.dec1();
            }
            System.out.println(Thread.currentThread().getName() + " end");
        });
        thread1.start();  // Запускаем потоки
        thread2.start();
        thread1.join();   // Вызываем метод join, чтобы основной поток
        thread2.join();   // дождался завершения запущенных потоков
        System.out.println(main);
    }

    /**
     * Конструктор для инициализации полей
     */
    public Example6(int c1, int c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    /**
     * Метод inc1, увеличивающий значение поля c1, синхронизация на мониторе mon1
     */
    public void inc1() {
        synchronized (mon1) { // если убрать критическую секцию - работать будет неправильно
            c1++;
        }
    }

    /**
     * Метод dec1, уменьшающий значение поля c1, синхронизация на мониторе mon1
     */
    public void dec1() {
        synchronized (mon1) { // если убрать критическую секцию - работать будет неправильно
            c1--;
        }
    }

    /**
     * Метод inc2, увеличивающий значение поля c2, синхронизация на мониторе mon2
     */
    public void inc2() {
        synchronized (mon2) { // если убрать критическую секцию - работать будет неправильно
            c2++;
        }
    }

    /**
     * Метод dec2, уменьшающий значение поля c2, синхронизация на мониторе mon2
     */
    public void dec2() {
        synchronized (mon2) { // если убрать критическую секцию - работать будет неправильно
            c2--;
        }
    }

    @Override
    public String toString() {
        return "Main{" + "c1=" + c1 + ", c2=" + c2 + "}";
    }
}

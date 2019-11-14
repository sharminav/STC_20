package lesson_07;

/**
 * ДЗ 7
 * @author Sharmin Aleksei
 */

public class Test {

    static int threadCount = 50;

    public static void main(String[] args) throws InterruptedException {

        // массив чисел
        Integer[] n = new Integer[threadCount];
        // заполнение массива чисел случайными числами
        for (int i = 0; i < threadCount; i++) {
            n[i] = (int)(Math.random() * 100);
        }

        // массив потоков
        Thread[] threads = new Thread[threadCount];
        // создание массива потоков
        for (int i = 0; i < threadCount; i++) {
            ThreadFactorial threadFactorial = new ThreadFactorial(n[i]);
            threads[i] = new Thread(threadFactorial, String.format("Thread %d", i));
        }
        startThreads(threads);
    }

    /**
     * Запуск потокав из массива
     * @param threads массив потоков
     */
    private static void startThreads(Thread[] threads) {
        for (Thread t : threads)
            t.start();
    }

 }

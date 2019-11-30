package lesson_12;

public class MyOutOfMemory {
    /**
     * Получение утечки памяти java.lang.OutOfMemoryError: Java heap space
     * @throws InterruptedException
     */
    static void demoOutOfMemoryError() throws InterruptedException {
        int arraySize = 100;
        for (int i = 1; i < 50; i++) {
            //Thread.sleep(10000);
            System.out.println("Round " + i + " Free Memory: " + Runtime.getRuntime().freeMemory());
            String[] arrayInt = new String[arraySize];
            arraySize = arraySize * 10;
        }
    }

}

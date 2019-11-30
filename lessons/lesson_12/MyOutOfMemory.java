package lesson_12;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Получение утечки памяти java.lang.OutOfMemoryError: Metaspace
     * @throws InterruptedException
     */
    static void demoOutOfMemoryError2() throws InterruptedException {
        List<String> stringList = new ArrayList<>();
        for (int i = 1; ; i++) {
            stringList.add("123");
        }
    }

}

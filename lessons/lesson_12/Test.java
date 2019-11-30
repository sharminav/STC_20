package lesson_12;


import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Задание 1.
 * Необходимо создать программу, которая продемонстрирует утечку памяти в Java.
 * При этом объекты должны не только создаваться, но и периодически частично удаляться,
 * чтобы GC имел возможность очищать часть памяти.
 * Через некоторое время программа должна завершиться с ошибкой
 * OutOfMemoryError c пометкой Java Heap Space.
 *
 * Задание 2.
 * Доработать программу так, чтобы ошибка OutOfMemoryError возникала в Metaspace /Permanent Generation
 */

public class Test {

    private static final int classCount = 50000;
    public static ArrayList<String> my = new ArrayList<>();
    public static int val = 0;

    public static void main(String[] args) throws Exception {
        MyOutOfMemory.demoOutOfMemoryError();
    }


}

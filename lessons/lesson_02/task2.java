package lesson_02;

import java.util.Random;

/**
 * @author Алексей Шарамин
 * Задание №2
 */
public class task2 {

    public static void main(String[] args) {
        int[] arr;
        arr = new int[10000];

        // Заполнение случайными числами
        Random random = new Random();
        for (var i = 0; i < arr.length; i++) {
            arr[i] = (random.nextInt(65536)-32768);
        }

        double q;
        int q_int;
        double q_pow;

        for (var i = 0; i < arr.length; i++) {
            try {
                if (arr[i] < 0) {
                    throw new Exception();
                }
                q = Math.sqrt(arr[i]);
                q_int = (int) q;
                q_pow = Math.pow(q_int, 2);
                if (q_pow == arr[i]) {
                    System.out.println(arr[i]);
                }
            } catch (Exception e) {
                System.out.println("Exception: отрицательное число в массиве");
            }

        }

    }
}

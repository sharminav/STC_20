package lesson_02;

import static java.lang.System.out;

/** ЗАДАНИЕ 1.
 * @author Алексей Шармин
 * Для проверки кажжого из заданий необходимо раскомментировать один из методов errorNullPointerException, ArrayIndexOutOfBoundsException, errorAnyException
 */
public class task1 {

    public static void main(String[] args) throws Exception {
        out.println("Hello world!");

        // Моделирование ошибки NullPointerException
        //errorNullPointerException();

        // Моделирование ошибки ArrayIndexOutOfBoundsException
        //errorArrayIndexOutOfBoundsException();

        // Моделирование своего варианта ошибки
        errorAnyException();
    }

    // Моделирование ошибки NullPointerException
    static void errorNullPointerException() {
        Integer x = null;
        x.toString();
    }

    // Моделирование ошибки ArrayIndexOutOfBoundsException
    static void errorArrayIndexOutOfBoundsException() {
        int[] arr;
        arr = new int[10];
        out.println(arr[11]);
    }

    // Моделирование своего варианта ошибки
    static void errorAnyException() throws Exception {
        throw new Exception("Создание собственной ошибки");
    }


}

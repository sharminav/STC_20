package lesson_07;

import java.math.BigInteger;

/**
 * Многопоточное вычисление факториала
 * @author Sharmin Aleksei
 */
public class Factorial {

    /**
     * Рекурсивная функция вычисления факториала
     * @param n число
     * @return факториал числа
     */
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.valueOf(1);
        BigInteger d, e, f;
        for (int i = 1; i <=n; i ++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}

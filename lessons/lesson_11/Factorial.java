package lesson_11;

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
    public static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= n.intValue(); i ++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}

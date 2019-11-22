package lesson_11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * ДЗ 7
 * @author Sharmin Aleksei
 */

public class Test {

    private static BigInteger factorialOp(FactorialFunc ff, BigInteger n) {
        return ff.func(n);
    }

    public static void main(String[] args) throws InterruptedException {

        // массив чисел
        List<Integer> n = new ArrayList<>();
        List<BigInteger> nFactorial;

        // создание списка случайных чисел
        SomeFunc<List> nList = (innerList) -> {
            for(int i = 0; i < 10; i++)
                innerList.add((int)(Math.random() * 100));
            return innerList;
        };
        n = nList.func(n);

        // печать списка из случйаных чисел
        System.out.println("-- начальный список --");
        n.forEach(System.out::println);

        // расчет факториала
        SomeFunc<List> nFactorialList = (innerList) -> {
            List<BigInteger> results = new ArrayList<>();
            ((List<Integer>)innerList).forEach((Integer value) -> results.add(factorialOp(Factorial::factorial, BigInteger.valueOf(value))));
            //results.forEach((BigInteger value) -> value = BigInteger.valueOf(1000));
            return results;
        };

        nFactorial = nFactorialList.func(n);

        // печать факториала через Stream
        System.out.println("-- список факториалов --");
        Stream.of(nFactorial)
                .forEach(System.out::println);

     }

 }

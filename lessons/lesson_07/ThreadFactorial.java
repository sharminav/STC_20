package lesson_07;

import java.math.BigInteger;

/**
 * @author Sharmin Aleksei
 */
public class ThreadFactorial implements Runnable {
        public int factorial;

        public ThreadFactorial(int n) {
            this.factorial = n;
        }

        @Override
        public void run(){
            System.out.println();
            BigInteger factorialResult = Factorial.factorial(factorial);
            System.out.println(Thread.currentThread().getName() + " - число - " + factorial + " результат - " + factorialResult);
        }
}

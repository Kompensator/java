import java.math.BigInteger;

public class UsefulMethods {
    public static void main(String[] args) {

    }
    
    static BigInteger Factorial(int n) {
        BigInteger factorial = new BigInteger("1");
        for (int i = 2;i <= n; i ++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return (factorial);
    }

    static BigInteger recursiveFactorial(int n) {
        BigInteger factorial = new BigInteger("1");
        for (int i = n; i >= 1; i --) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return (factorial);
    }

    static double biggest(double[] numbers) {
        double biggest = numbers[0];
        for (int i = 1; i < numbers.length; i ++) {
            if (numbers[i] > biggest) {
                biggest = numbers[i];
            }
        }
        return (biggest);
    }
    static double smallest (double[] numbers) {
        double smallest = numbers[0];
        for (int i = 1; i < numbers.length; i ++) {
            if (numbers[i] < smallest) {
                smallest = numbers[i];
            }
        }
        return (smallest);
    }

    static BigInteger[] Fib(int n) {
        BigInteger[] numbers = new BigInteger[n];
        numbers[0] = BigInteger.ONE;
        numbers[1] = BigInteger.ONE;
        for (int i = 2; i < n; i ++) {
            BigInteger last = numbers[i - 1];
            BigInteger second_last = numbers[i - 2];
            BigInteger next = last.add(second_last);
            numbers[i] = next;
        }
        return (numbers);
    }
}
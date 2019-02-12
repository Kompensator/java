import java.math.BigInteger;
import java.util.Arrays;

public class Fib {
    static BigInteger[] generator(int n) {
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
    public static void main(String[] args) {
        int limit = 200;
        BigInteger[] sequence = new BigInteger[limit];
        sequence = generator(limit);
        System.out.println(Arrays.toString(sequence));
    }
}

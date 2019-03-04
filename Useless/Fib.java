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
<<<<<<< HEAD
        int limit = 200;
        BigInteger[] sequence = new BigInteger[limit];
        sequence = generator(limit);
        System.out.println(Arrays.toString(sequence));
=======
<<<<<<< HEAD
		int iter = 1000000;
        Scanner reader = new Scanner(System.in);
        long[] sequence = new long[iter];
        sequence = generator(iter);
        // System.out.println("Enter query: ");
        // int query = reader.nextInt();
=======
        int limit;
        limit = Integer.parseInt(args[0]);
        long[] sequence = new long[limit];
        sequence = generator(limit);
>>>>>>> f2625d112763e9184a34c53a83db0fb84e4fea29
>>>>>>> 2d495d9c1bbd2d432df10bf79dc9b0db98d1747c
    }
}

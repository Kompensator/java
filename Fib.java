import java.util.Scanner;

public class Fib {
    static long[] generator(int n) {
        long[] numbers = new long[n];
        numbers[0] = 1;
        numbers[1] = 1;
        int i = 2;
        while (i < n) {
            long last = numbers[i - 1];
            long second_last = numbers[i - 2];
            long next = last + second_last;
            System.out.println(i+" : "+second_last+ " + "+last+" = "+next);
            numbers[i] = next;
            i += 1;
        }
        return (numbers);
    }
    public static void main(String[] args) {
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
    }
}

import java.util.Arrays;

public class Euler7 {
    public static void main(String[] args) {
        int[] primes = primeGen(10001);
        System.out.println(primes[10000]);

    }

    static int[] primeGen(int n) {
        int[] primes = new int[n];
        primes[0] = 2;
        primes[1] = 3;
        int primeCounter = 2;
        int i = 5;
        while (primeCounter < n) {
            for (int j = 2; j < i; j ++) {
                if (i % j == 0){
                    break;
                } else if (j == i - 1) {
                    primes[primeCounter] = i;
                    primeCounter ++;
                }
            }
            i += 2;
        }
        return primes;
    }
}
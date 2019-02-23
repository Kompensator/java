public class PE5 {
    public static void main(String[] args) {
        int upperLimit = 50;
        int[] primeFactorization = new int[upperLimit];
        int primeProduct = 2;
        primeFactorization[0] = 2;
        for (int i = 3; i < upperLimit; i ++) {
            int newPrime = factorize(primeFactorization, i);
            if (newPrime != 0) {
                primeProduct *= newPrime;
                for (int j = 0; j < upperLimit; j++) {
                    if (primeFactorization[j] != 0) {
                        primeFactorization[j] = newPrime;
                    }
                }
            }
        }
       
    System.out.println(primeProduct);
    }
    static int factorize(int[] primes, int number) {
        for (int i = 0; i < primes.length; i ++) {
            try {
            if (number % primes[i] == 0) {      // length of array is 50!!
            number = number/primes[i];
            }
        } catch (Exception e) {;}
        }
        if (number != 1) {
            return number;
        }
        else {
            return 0;
        }
    }
}
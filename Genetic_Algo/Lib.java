import java.util.Random;
import java.util.Arrays;

public class Lib {
    static Random random = new Random();

    static int[][] init_mutation(int[] parent, int n, int k) {
        /* mutates the parents chromosome n times
        returns k copies
        */ 
        int[][] newChromosomes = new int[k][243];
        int[] mod = new int[243];
        newChromosomes[0] = parent;
        for (int i = 1; i < k; i ++) {
            System.arraycopy(parent, 0, mod, 0, 243);
            for (int j = 0; j < n; j++) {
                mod[random.nextInt(243)] = random.nextInt(7);
            }
            newChromosomes[i] = mod;
        }
        return newChromosomes;
    }

    static int randint(int end) {
        /* similar to random.randint() in Python
        **/
        int n = (int)(Math.random()*(end));
        return n;
    }

    static int[][] twoDIntDeepcopy(int[][] src) {
        /* deep copies a non ragged 2D int array
        returns the deep copy of the array
        **/
        int[][] dest = new int[src.length][src[0].length];
        for (int i = 0;i < src.length; i++) {
            for (int j = 0; j < src[0].length; j++) {
                dest[i][j] = src[i][j];
            }
        }
        return dest;
    }

    static void printStats(double[] stats) {
        /* prints the relevant statistics of a double array
        void return, everything is done in the function
        **/
        double sum = 0.;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0;i < stats.length;i++) {
            sum += stats[i];
            if (stats[i] > max) {
                max = stats[i];
            }
            if (stats[i] < min) {
                min = stats[i];
            }
        }
        System.out.println("Mean = " + sum/stats.length);
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);

        Arrays.sort(stats);     // to print the 5 largest values
        System.out.println("The 5 largest values:");
        for (int i = stats.length - 1;i > stats.length - 1 - 5; i--) {
            // prints the max 5 values
            System.out.println(stats[i]);
        }
    }
}
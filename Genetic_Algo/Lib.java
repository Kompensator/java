import java.util.Random;


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
}
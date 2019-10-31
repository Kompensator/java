import java.util.Random;

public class Eyes {
    static Random rng = new Random();
    
    static double children(int n) {
        double blueEyes = 0;
        for(int i = 0;i < n;i++) {
            if (rng.nextInt(4) == 0) {
                blueEyes++;
            }
        }
        return blueEyes/(double)n;
    }

    public static void main(String[] args) {
        double accum;
        double prob;
        
        for (int i = 1;i < 100;i++) {
            accum = 0;
            int n = 8;
            for (int j = 0;j < 1000000;j++) {
                accum += children(n);
            }
            prob = accum / 1000000.0;
            System.out.println(prob);
        }
    }
}
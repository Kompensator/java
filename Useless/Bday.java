import java.util.Random;
import java.util.Arrays;

public class Bday {
    static Random rng = new Random();

    static int randint(int min, int max) {
        return min + rng.nextInt(max) + 1;
    }

    static int bday(int size) {
        int[] birthdays = new int[size];

        for(int i = 0;i < birthdays.length;i++) {
            birthdays[i] = randint(0, 365);
        }
        Arrays.sort(birthdays);

        for(int i = 1;i < birthdays.length;i++) {
            if (birthdays[i-1] == birthdays[i]) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        double [] results = new double[100];
        
        for(int i = 0;i < results.length;i++) {
            double sum = 0;
            for(int j = 0;j < 10000;j++) {
                sum += bday(i);
            }
            results[i] = sum/10000.0;
        }

        System.out.println(Arrays.toString(results));
    }
}
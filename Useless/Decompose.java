import java.util.Arrays;
import java.util.Scanner;

public class Decompose{
    static int[] decToBin(int dec){
// THIS IS THE SIZE OF THE ARRAY
        int[] bin = new int[32];
        while (dec != 0) {
            int n;
            n = fitPower(dec);
            bin[n] = 1;
            dec = dec - (int) Math.pow(2,n);
        }

        return (reverseArray(bin));
    }

    static int[] reverseArray(int[] array) {
        int len = array.length;
        int[] new_array = new int[len];
        for (int i = 0; i < len; i += 1) {
            new_array[i] = array[len-1-i];
        }
        return (new_array);

    }

    static int fitPower (int num) {
        // fits the highest power of 2 that is less than num
        int n = 0;
        while (num >= Math.pow(2,n)) {
            n += 1;
        }
        return (n - 1);
    }
    public static void main (String[] args) {
        Scanner reader = new Scanner(System.in);
        int dec;
        dec = reader.nextInt();
        int bin[] = decToBin(dec);
        System.out.println(Arrays.toString(bin));
    }
}

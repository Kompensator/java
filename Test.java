import java.util.Scanner;
import Planet;

public class Test{
    public static void main(String[] args){
        double zero_matrix[][] = new double[100000][2];
        Planet sun = new Planet("SUN", 1e6, 1200, 1200, 100, 100, 0, 0, zero_matrix);
        sun.nextStep(12);
        System.out.println(sun);

    }
}
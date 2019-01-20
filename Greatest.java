import java.util.Arrays;

public class Greatest {
    static int compare(int[] numbers) {
        if (numbers.length > 2) {
            if (numbers[0] > compare(Arrays.copyOfRange(numbers, 1, numbers.length))) {
                return (numbers[0]);
            } else{
                return (compare(Arrays.copyOfRange(numbers, 1, numbers.length)));
            }

        } else{
            if (numbers[0] > numbers[1]) {
                return (numbers[0]);
            } else {
                return (numbers[1]);
            }
        }
    }
    static int better_compare(int[] numbers) {
        int temp = numbers[0];
        for (int i = 1; i < numbers.length; i ++) {
            if (numbers[i] > temp) {
                temp = numbers[i];
            }
        }
        return (temp);
    }
    public static void main (String[] args) {
        int[] numbers = {1,4,6,52445,1000000,4256422,1005,35,67894,-24};
        System.out.println(compare(numbers));
        System.out.println(better_compare(numbers));
    }
}

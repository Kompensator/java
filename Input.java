import java.util.Scanner;
public class Input {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Hey!\nEnter something to print out");
        String word = reader.nextLine();
        System.out.println(word);
        String another_word = reader.nextLine();
        System.out.println(another_word);
        reader.close();
    }
}

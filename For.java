public class For{
    public static void main (String[] args){
        for (int i = 0; i <= 5; i++) {    // semicolon ; needed after each statement!!
            System.out.println(i);
        }
        String[] stuff = {"person", "computer","other stuff"};
        for (String i : stuff) {
            System.out.println(i.toUpperCase());
        }
        int[] numbers = {0,1,2,3,4,5,6,7,8,9};
        for (int i : numbers) {
            if (i == 4) {
                continue;
            }else if (i == 6){
                break;
            }
            System.out.println(i);
        }
    }
}

public class Conditional {
    public static void main (String[] args) {
        int num1 = 10;
        float num2 = 10.0f;
        if (num1 > num2) {  // should return false
            System.out.println(num1+ " is greater to "+ num2);
        } else if (num1 < num2) {
            System.out.println(num1+ " is smaller than "+num2);
        } else {
            System.out.println("they're equal");
        String result = (10 < 20) ? "this worked" : "this might not have worked";
        System.out.println(result);
        }
    }
}

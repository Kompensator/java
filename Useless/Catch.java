public class Catch {
    static void checkAge (int age) {
        if (age < 21) {
            throw new ArithmeticException("Access Denied");

        } else {
            System.out.println("Access Granted");
        }
    }
    public static void main (String[] args) {
        float i, j;
        i = 0.0f;
        j = 0.0f;
        try {
            System.out.println(j/i);
        }
        catch (Exception e) {
            System.out.println("you fked up");
        }
        finally {
            System.out.println("try catch done!");
            checkAge(24);
        }
    }
}

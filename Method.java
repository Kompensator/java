public class Method {
    static void myMethod() {
        System.out.println("hello world again");
    }
    public static void main (String[] args) {
        myMethod();
        int a,b;
        a = 5;
        b = 1;
        int sum = add(a,b);
        System.out.println(sum);
    }
    static int add(int a, int b) {
        return a+b;
    }
}

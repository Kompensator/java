public class MyMethod {
    static void StaticMethod() {
        System.out.println("you just called a static method, hello world");
    }
    public void PublicMethod() {
        System.out.println("you just called a public method");
    }
    public static void main (String[] args) {
        StaticMethod();  // static methods can be called without creating an object
        MyMethod myobject = new MyMethod();  // have to create an instance of MyMethod first to call PublicMethod
        myobject.PublicMethod();   // calling PublicMethod from myobject
    }
}

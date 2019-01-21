public class Oop {
    public static void main (String[] args) {
        Stuff thing = new Stuff();
        thing.function("hello world");
        Stuff other_thing = new Stuff();
        other_thing.function("print somethign else");
    }
}

class Stuff{
    public void function(String message){
        System.out.println(message);
    }
}

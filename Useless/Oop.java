public class Oop {
    public static void main (String[] args) {
        System.out.println(function(5));  // i didnt need to create an instance of Oop to use function. hence why function is static
        Student Manuel = new Student("Manuel", 19, 99.999);
        String returnMessage = Manuel.setNewGrade(85.5555);  // invokes setNewGrade method on manuel
        System.out.println(Manuel.grade);  // prints out the new grade attribute
        System.out.println(Manuel);  // what will this print out?

        Student Ding = new Student("Ding Yi", 18, 69.420);
        returnMessage = Ding.setNewGrade(420.69);
        System.out.println(Ding.grade);
    }
    static int function(int x) {
        return(x*x);
    }
}

class Student {
    String name;
    int age;
    double grade;

    public Student(String input1, int input2, double input3) {
        // this method is the constructor. it runs as you make an object of Student class (in this case Manuel)
        name = input1;
        age = input2;
        grade = input3;
        System.out.println("Student class "+name+" created. Age: "+age+"grade: "+grade);
    }
    public String setNewGrade(double newGrade) {
        grade = newGrade;
        return ("new grade for "+name+" is "+grade);
    }
    
    static void function(int x) {
        System.out.println(x*x);
    }
    public String toString() {
        return ("object "+name);
    }

}


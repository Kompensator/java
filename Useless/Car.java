public class Car {
    public void fullThrottle() {
        System.out.println ("car is going very fast");
    }
    public void speed (int maxspeed) {
        System.out.println("max speed of the car is " + maxspeed);
    }
    public static void main(String[] args) {
        Car Porsche = new Car();
        Porsche.fullThrottle();
        Porsche.speed(300);
    }
}

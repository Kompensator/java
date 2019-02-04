public class Planet {
    /* Class planet
    creates a Planet with 2d position and velocities, and point mass
    */
    String name;
    double mass, x, y, vx, vy, ax, ay;
    double[][] position_history;
    public Planet(String name, double mass, double x, double y, double vx, double vy, double ax, double ay, double[][] position_history) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.ax = ax;
        this.ay = ay;
        this.mass = mass;
        this.position_history = position_history;
    }
    public String toString() {
        return (name+" at x= "+x+"  y= "+y);
    }
    public void nextStep(int dt) {
        this.x += this.vx * dt;
        this.y += this.vy * dt;
    }
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
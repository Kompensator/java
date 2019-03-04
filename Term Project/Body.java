public class Body {
    // Attributes: x, y, vx, vy, ax, ay, mass, radius
    double x, y, mass, vx, vy, ax, ay, radius;
    String name;

    public Body (double x, double y, double vx, double vy, double mass, double radius, String name) {
        // constructor
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.mass = mass;
        this.radius = radius;
        this.name = name;
        this.ax = 0;
        this.ay = 0;
    }

    public void updateAcceleration (Body[] bodies) {
        // updates ax and ay of the body with respect to other bodies
        final double G = 6.6740831e-11;      // thinks this is
        for (int i = 0; i < bodies.length; i ++) {
            Body otherBody = bodies[i];
            if (otherBody.name != this.name){       // makes sure a body doesn't calculate acc on itself
                double r = Math.sqrt(Math.pow((this.x - otherBody.x),2) + Math.pow((this.y - otherBody.y),2));
                double temp_acc;
                try {
                    temp_acc = (G * otherBody.mass)/Math.pow(r,3);       // temp_acc * deltax = ax
                }
                catch (ArithmeticException e){
                    temp_acc = 0;
                }
            
            this.ax += temp_acc * (otherBody.x - this.x);
            this.ay += temp_acc * (otherBody.y - this.y);
            }
        }

    }
    public void updateVelocity (Body[] bodies, int dt) {
        // computes the updated velocity with ax and ay
        this.updateAcceleration(bodies);
        this.vx += this.ax * dt;
        this.vy += this.ay * dt;
    }

    public void updatePosition(Body[] bodies, int dt) {
        // updates the x, y
        this.updateVelocity(bodies, dt);
        this.x += this.vx * dt;
        this.y += this.vy * dt;
    }
    public static void main (String[] poop) {
        Body[] bodies = new Body[2];
        int dt = 10;
        bodies[0] = new Body(0,0,0,0,2e30,50000, "Sun");
        bodies[1] = new Body(1.47e10,0,0,3e4,6e24,1000, "Earth 2");
        for (int i = 0; i < 1000; i ++){
            bodies[0].updatePosition(bodies,dt);
            bodies[1].updatePosition(bodies,dt);
            // System.out.println(bodies[0].x);
            System.out.println(bodies[0].y);

        }
    }
}
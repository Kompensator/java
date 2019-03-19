package body;

public class Body {
    // Attributes: x, y, vx, vy, ax, ay, mass, radius
    public double x, y, mass, vx, vy, ax, ay, radius,temp_x,temp_y;
    public String name;
    public boolean merged;      // for two bodies merging into one

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
        this.temp_x = x;
        this.temp_y = y;
        this.merged = false;
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

    public void calculatePosition(Body[] bodies, int dt) {
        // calculates the new positions and stores them in temp_x and temp_y
        this.updateVelocity(bodies, dt);
        this.temp_x += this.vx * dt;
        this.temp_y += this.vy * dt;
    }

    public void updatePosition() {
        // this method should be called after calling calculatePosition
        // replaces position with temporary values

        this.x = this.temp_x;
        this.y = this.temp_y;
    }

    public static void main(String[] poop) {;}
    }

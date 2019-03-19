import java.io.File;
import java.io.FileWriter;
import java.io.*;
import body.Body;

public class Write {
    public static void main (String[] args) throws IOException {
        File file = new File("/Users/DY/java/Term Project/position.data");
        FileWriter writer = new FileWriter(file);

        int n = 5;      // number of bodies
        int dt = 7200;
        double simTime = 1e9;
        long totalSteps = (long) Math.round(simTime / dt);

        Body[] bodies = new Body[n];
        // add Bodie to bodies
        for (int i = 0; i < n; i ++) {
            String bodyName = "Body" + i;
            bodies[i] = new Body(randint(-3e11, 3e11), randint(-3e11, 3e11), randint(-1e5, 1e5), randint(-1e5, 1e5), 1e30, 1e5, bodyName);
        }
        // bodies[0] = new Body(1.5e11, 0, 0, 3e4, 6e24, 1e6, "Earth");
        // bodies[1] = new Body(0, 0, 0, 0, 2e30, 1e6, "Sun");

        for (int step = 0; step < totalSteps; step++) {
            for (int i = 0; i < n; i ++) {
                bodies[i].calculatePosition(bodies, dt);
            }

            for (int i = 0; i < n; i ++) {
                bodies[i].updatePosition();
                writer.write(Double.toString(bodies[i].x));
                writer.write("\n");
                writer.write(Double.toString(bodies[i].y));
                writer.write("\n");
            }
        }

        writer.close();

    }

    static double randint(double min, double max) {
        /* Return a random integer ranged from min to max
        similar function to random.randint() in python
        */
        return Math.random() * (max - min + 1) + min;
    }
}

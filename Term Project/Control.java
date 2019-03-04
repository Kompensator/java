import Body.Body;

public class Control {


    public static void main (String[] poop) {
        Body[] bodies = new Body[2];
        bodies[0] = new Body(0,0,100,100,100000,500, "body 1");
        bodies[1] = new Body(10000,10000,-100,-50,10000000,1000, "body 2");
        bodies[0].calc_acceleration(bodies);
        System.out.println(bodies[0].ax +' '+bodies[0].ay);
    }
}
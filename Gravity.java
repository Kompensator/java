import Planet;
public class Gravity {
    static void calculateAcceleration(Planet body1, Planet body2) {
        double g_constant = 6.6740831;
        double ax1, ax2, ay1, ay2;
        double r = math.sqrt((math.pow((body1.x - body2.x), 2) + math.pow((body1.y - body2.y),2));
        body1.ax = g_constant * body2.mass/ (body1.x)
    }
    public static void main (String[] args) {
        
    }
}
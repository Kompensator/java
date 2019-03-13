import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.*;

public class twoBody {
	public static void main(String[] args) throws IOException {
		
		Scanner kbrd = new Scanner(System.in);
		
		File file = new File("/Users/DY/java/Term Project/twoBody.data");
		
		FileWriter writer = new FileWriter(file);
		
		//vars
		double x1 , y1 , m1 , vx1 , vy1 , ax1 , ay1; //obj 1
		double x2 , y2 , m2 , vx2 , vy2 , ax2 , ay2; //obj 2
		double r;
		double dx , dy; //separation values
		int ctr = 0;
		double diam;
		String begin;
		
		//constants
		double dt = 0.1;
		double G = 6.67e-11;
		
		//create file for data
		boolean x = file.createNewFile();
		System.out.println(x);
		
		System.out.println("Input initial coordinates: ");
		
		x1 = kbrd.nextDouble(); System.out.print(", "); y1 = kbrd.nextDouble();
		
		x2 = kbrd.nextDouble(); System.out.print(", "); y2 = kbrd.nextDouble();
		
		dx =(x2-x1); dy =(y2-y1); r =Math.sqrt(dx*dx + dy*dy);
		
		vx1 = 0; vx2 = 0; vy1 = 0; vy2 = 0;
		
		
		System.out.println("\nInput two masses (in kilograms): ");
		m1 = kbrd.nextDouble();
		m2 = kbrd.nextDouble();
		
		System.out.print("Input diameter of objects (in m): ");
		diam = kbrd.nextDouble();
		
		System.out.println("The calculations will begin now. This may take some time, and with lots of numbers on screen.\nThis is normal. Don't worry.\nTo begin, enter the letter y.");
		begin = kbrd.nextLine();
		
		while(begin.equals("y") == false) {
			begin = kbrd.nextLine();
		}
		
		while(r >= diam) {
			
			
			ax1 =(dx/r)*((G*m2)/(r*r));
			vx1 = vx1 + ax1*dt;
			x1 = x1 + vx1*dt;
			
			ax2 =-(dx/r)*((G*m1)/(r*r));
			vx2 = vx2 + ax2*dt;
			x2 = x2 + vx2*dt;
			
			
			ay1 =(dy/r)*((G*m2)/(r*r));
			vy1 = vy1 + ay1*dt;
			y1 = y1 + vy1*dt;
			
			ay2 = -(dy/r)*((G*m1)/(r*r));
			vy2 = vy2 + ay2*dt;
			y2 = y2 + vy2*dt;
			
			dx =(x2-x1); dy =(y2-y1); r =Math.sqrt(dx*dx + dy*dy);
			
		 
			
			writer.write(x1 + ", " + y1 + " : " + x2 + ", " + y2 + "\n");
			
			ctr++;		
		}
		
		writer.close();
		kbrd.close();
		
		System.out.println("\nCollision occured at (" + x1 + ", " + y1 +") , after " + ctr*dt + " seconds.");
		
	}
	 	
	
}
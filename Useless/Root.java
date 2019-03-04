import java.util.Scanner;





public class Root
{
   public static void main(String[] args)
   {
	   double xsub0;
	   double xsub0initial;
	   double xsub1;
	   int counter;
	   
	   
	    // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);
	  System.out.print("please enter an initial value for x:");
	  xsub0 = keyboard.nextDouble();
	  
	  xsub0initial = xsub0;
	  counter = 0;
	  xsub1 = 0;
	  while ((xsub0-xsub1) > 0.0001) {
		  xsub1 = newtonRaphsonF (xsub0);
		  counter = counter + 1;
		  System.out.println("xn " + xsub0 + " xnplus1 " + xsub1);
		  xsub0 = xsub1;
	  }
	  System.out.println("FINAL:");
	  System.out.println("xn " + xsub0 + " xnplus1 " + newtonRaphsonF (xsub0));
	  System.out.println("polynomial: 3x^5+x^3-x-1");
	  System.out.println("derivative=15x^4+3x^2-1");
	  System.out.println("Initial x given: " + xsub0initial);
	  System.out.println("Root approximation: " + newtonRaphsonF(xsub0));
	  System.out.println("Iterations: " + counter);
	  System.out.println("Coded by Andrew Salem");
   }
	  
		  
	  
	  
	  //this is the method for f of x
	  public static double f(double x) {
		double fofx;
		fofx = 3*Math.pow(x,5) + Math.pow(x,3) - x -1;
		return fofx;
	  }
	  
	  // this is the method for the derivative of f
	  public static double fprime(double x) {
		  double fprimeofx;
		  fprimeofx = 15*Math.pow(x,4) + 3*Math.pow(x,2) - 1;
		  return fprimeofx;
	  }
	  
	  //The method for the NewthonRapson algorythm
	  public static double newtonRaphsonF (double x) {
		  double newtonRaphsonFofxsub0;
		  newtonRaphsonFofxsub0 = x - (f(x)/fprime(x));
		  return newtonRaphsonFofxsub0;
	  }
}
	  
		  
	  
	  
	  
	  
	  
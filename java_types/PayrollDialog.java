import java.util.Scanner;  // Needed for the Scanner class

/**
   This program demonstrates the Scanner class.
*/

public class PayrollDialog
{
   public static void main(String[] args)
   {
      String name;         // To hold a name
      int hours;           // Hours worked
      double payRate;      // Hourly pay rate
      double grossPay;     // Gross pay

      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);

      // Get the user's name.
      System.out.print("Enter your number? ");
      name = keyboard.nextLine();

      int sl = name.length();
      char in1 = name.charAt(sl-1);
      String index = String.valueOf(in1);
	  name.concat(index);
	  in1 = name.charAt(sl-2);
	  index = String.valueOf(in1);
	  name.concat(index);
  	  in1 = name.substring(sl-3, sl-3);
	  in1 = name.charAt(sl-2);
	  index = String.valueOf(in1);
	  name.concat(index);



      // Display the resulting information.
      System.out.println("Hello, ");
      System.out.println("the inverse is " + name);
   }
}

//package labexercises;

import java.util.Scanner;

/**
 * Computes and displays the average of three integer values.
 *
 * @author     Carmen Legendre/Alex Simonelis/Ding Yi Zhang
 * @version    28/01/2018
 */

public class Average
{
    public static void main (String[] args){
		// try to run everything, catch all errors
		try {
		Scanner keyboard =  new Scanner(System.in);
		double average;
		System.out.println("Enter the number of numbers xD");
		int n = keyboard.nextInt();
		double sum = 0;
		for (int i = 0; i < n; i ++) {
			System.out.print("Enter number in base 10 > ");
			double number = keyboard.nextDouble();
			sum += number;
		}
		average = sum/n;
		System.out.println("Average is "+average);
		keyboard.close();
	}
		catch (Exception e) {
			System.out.println("something happened! Sorry! The program will rerun.");
			main(null);
		}

	} // end of main()

} //end of class






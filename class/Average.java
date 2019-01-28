//package labexercises;

import java.util.Scanner;

/**
 * Computes and displays the average of three integer values.
 *
 * @author     Carmen Legendre/Alex Simonelis
 * @version    09/03/2010
 */

public class Average
{
    public static void main (String[] args)
    {
	//variable declarations
	Scanner keyboard =  new Scanner(System.in);
	int number1, number2;
	double average;

	//Accept the required data

	System.out.print ("Enter the first number: ");
	number1 = keyboard.nextInt();

	System.out.print ("Enter the second number: ");
	number2 = keyboard.nextInt();

	//Process the data in order to determine the average of the numbers
	average = (number1 + number2) / 2;

	//Display the output
	System.out.println ("************** Average ****************");
	System.out.println ();
	System.out.println ("Number 1:             " + number1);
	System.out.println ("Number 2:             " + number2);
	System.out.println ();
	System.out.println ("Average:              " + average);
	System.out.println ("\n\nWritten by: Carmen Legendre/Alex Simonelis");

    } //end main method
} //end Average class





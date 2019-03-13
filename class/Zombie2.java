/**
 Lab 1 - Modelling a zombie epidemic

 Authors: J. Sumner, J.F. Briere and S. Bhatnagar
 Current version written: February 2019
 Description: Euler solution of zombie SIR model
 */

// Import packages
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import org.math.plot.*;
import org.math.plot.plotObjects.*;
import java.util.Arrays;

public class Zombie2
{
    // Declare constants and parameters
    public static final double dt = 0.01;        // Time step (in days)
    public static final double tFinal = 60.0;   // Total time of simulation (in days)
    public static double alpha = 0.005;         // Zombie "deaths" per 1000 zombies per 1000 persons per day
    public static double beta = 0.0095;         // Zombie "infections" per 1000 zombies per 1000 persons per day
    public static double zeta = 0.0001;         // Zombie "resurrections" per 1000 dead zombies per day
    public static double delta = 0.0;        // 2009 world crude death rate per 1000 persons per day
    public static double pi = 0;           // 2012 world crude birth rate per 1000 persons per day
    public static double kappa = 2.;
    public static double epsilon = 0.05;       // rate of zombie death by natural causes, same unit as above ^
    public static double c = 130;
    public static double research_per_person = 4e-9;   // how much each human can contribute to develop immunity, works with 4e-9


    // Start main method
    public static void main(String[] args)
    {

        ////////////////////////////////////////////////////////////////////////
        // 1. Opening a file to store data
        ////////////////////////////////////////////////////////////////////////
        String filename = "ZombieSimulationOutput.txt";
        PrintWriter outputFile = null;
        try
        {
            outputFile = new PrintWriter(new FileOutputStream(filename,false));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File error.  Program aborted.");
            System.exit(0);
        }


        ////////////////////////////////////////////////////////////////////////
        //2. Declaring and initializing main variables
        ////////////////////////////////////////////////////////////////////////
        double S;        // Number of susceptibles (in thousands)
        double Z;	// Number of zombies (in thousands)
        double R;	// Number of deads (in thousands)
        double t;	// Time of the simulation (in days)
        double L;   // Amount of latent population
        double research;
        double research_done = 0;    // immunity is developped by healthy humans, and reduces the rate of infection
        double immunity;

        S = 500.;       // 500 000 healthy people
        Z = 0.001;      // 1 zombie
        R = 0.;
        t = 0.;
        L = 0.;

        // Print initial values to file using c-style printf
        outputFile.printf("%2.4f\t%6.1f\t%6.1f\t%6.1f\n",t,Z,S,R);


        ////////////////////////////////////////////////////////////////////////
        //3. Using Euler's method to evolve the solution
        ////////////////////////////////////////////////////////////////////////
        // Max number of steps
        int N = (int)(tFinal / dt) + 1;

        // Euler loop for first scenario
        for (int i = 1; i < N; i++)
        {
            research = research_per_person * S;
            research_done += research;
            immunity = diminishingReturn(research_done, c);
            S = S - (beta - immunity) * S * Z * dt;
            L = L + (beta - immunity) * S * Z * dt - kappa * L * dt;
            Z = Z + kappa * L * dt - alpha * S * Z * dt - epsilon * Z * dt;
            R = R + alpha * S * Z * dt + epsilon * Z * dt;         // zombies cannot resurrect from removed
            t = t + dt;

            System.out.println()

            outputFile.printf("%2.4f\t%6.1f\t%6.1f\t%6.1f\n",t,Z,S,R);
        }



        ////////////////////////////////////////////////////////////////////////
        //4.  Clean up after yourself!
        ////////////////////////////////////////////////////////////////////////
        // ALWAYS, ALWAYS close your file before exiting!
        outputFile.close();


        ////////////////////////////////////////////////////////////////////////
        //5.  Some magic to plot the data
        ////////////////////////////////////////////////////////////////////////
        // NOTE: This is a temporary work-around until we know more about arrays!

        // Reimporting the data to store them as an array
        int i = 0;

        // Open the file
        File file = new File(filename);

        // Allocate the arrays
        double[] time = new double[N];
        double[] Zombies = new double[N];
        double[] Susceptibles = new double[N];
        double[] Removed = new double[N];

        try
        {
            Scanner inputFile = new Scanner(file);
            while (inputFile.hasNext() && i < N)
            {
                try
                {
                    String str = inputFile.next();
                    time[i] = Double.parseDouble(str);

                    str = inputFile.next();
                    Zombies[i] = Double.parseDouble(str);

                    str = inputFile.next();
                    Susceptibles[i] = Double.parseDouble(str);

                    str = inputFile.next();
                    Removed[i] = Double.parseDouble(str);
                }
                catch (java.util.InputMismatchException ex)
                {
                    System.out.println("value " + time[i]);
                }

                i++;
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }


        ////////////////////////////////////////////////////////////////////////
        //6.  Now we can plot!
        ////////////////////////////////////////////////////////////////////////
        // Create a PlotPanel (you can use it like a JPanel)
        Plot2DPanel plot = new Plot2DPanel();

        // Define the legend position
        plot.addLegend("SOUTH");

        // Add a line plot to the PlotPanel
        plot.addLinePlot("Zombies", time, Zombies);
        plot.addLinePlot("Susceptibles", time, Susceptibles);
        plot.addLinePlot("Dead", time, Removed);
        plot.setAxisLabel(0,"Time (days)");
        plot.getAxis(0).setLabelPosition(0.5,-0.1);
        plot.setAxisLabel(1,"Population (thousands)");
        BaseLabel title = new BaseLabel("Zombie Outbreak", Color.BLACK, 0.5, 1.1);
        title.setFont(new Font("Courier", Font.BOLD, 14));
        plot.addPlotable(title);

        // Add maximums
        String[] scales = new String[2];
        scales = plot.getAxisScales();
        Arrays.sort(Zombies);
        Arrays.sort(Susceptibles);
        Arrays.sort(Removed);
        Arrays.sort(time);
        double maxZ = Zombies[Zombies.length-1];
        double maxS = Susceptibles[Susceptibles.length-1];
        double maxR = Removed[Removed.length-1];
        double maxT = time[time.length-1];
        String labelZ = new String("Max: "+maxZ);
        plot.addLabel(labelZ,plot.COLORLIST[0], maxT*1.1, maxZ);
        String labelS = new String("Max: "+maxS);
        plot.addLabel(labelS,plot.COLORLIST[1], maxT*1.1, maxS);
        String labelR = new String("Max: "+maxR);
        plot.addLabel(labelR,plot.COLORLIST[2], maxT*1.1, maxR);


        JFrame frame = new JFrame("Output of zombies.java");
        frame.setSize(525, 525);
        frame.setContentPane(plot);
        frame.setVisible(true);
    }

    static double diminishingReturn(double x, double c) {
        double exp = 1 - Math.exp(-c*x);
        return (exp)*beta;
    }
}

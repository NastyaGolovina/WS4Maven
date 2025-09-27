package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /** Static variable **/
    static Scanner input = new Scanner(System.in);
    static void main() {

        int count = inputInt("Enter number of  doubles: ");

        double[] values = new double[count];

        for (int i = 0; i < count; i++) {
            values[i] = inputDouble("Enter " + (i+1) + " double : ");
        }


        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        for (double v : values) {

            descriptiveStatistics.addValue(v);
        }

        double mean = descriptiveStatistics.getMean();
        double median = descriptiveStatistics.getPercentile(50);
        double standardDeviation = descriptiveStatistics.getStandardDeviation();

        System.out.println("Mean : " + mean);
        System.out.println("Median : " + median);
        System.out.println("Standard Deviation : " +standardDeviation);

    }




    /**
     * Input Integer
     *
     * @param message which will output during the ask
     * @return int
     */
    public static int inputInt(String message) {
        int line = -1;
        boolean isSomethingWentWrong = false;
        System.out.println(message);
        try {
            line = input.nextInt();

        } catch(Exception  e) {
            System.out.println("Something went wrong");
            System.out.println(message);
            isSomethingWentWrong = true;
        }
        input.nextLine();
        while (line < 0) {
            if (!isSomethingWentWrong)
            {
                System.out.println("Value less or equal 0");
                System.out.println(message);
            }
            try {
                isSomethingWentWrong = false;
                line = input.nextInt();

            } catch(Exception  e) {
                System.out.println("Something went wrong");
                System.out.println(message);
                isSomethingWentWrong = true;
            }
            input.nextLine();
        }
        return line;
    }


    /**
     * Input Double
     *
     * @param message which will output during the ask
     * @return double
     */
    public static double inputDouble(String message) {
        double line = -1;
        boolean isSomethingWentWrong = false;
        System.out.println(message);
        try {
            line = input.nextDouble();

        } catch(Exception  e) {
            System.out.println("Something went wrong");
            System.out.println(message);
            isSomethingWentWrong = true;
        }
        input.nextLine();
        while (line <= 0) {
            if (!isSomethingWentWrong)
            {
                System.out.println("Value less or equal 0");
                System.out.println(message);
            }
            try {
                isSomethingWentWrong = false;
                line = input.nextDouble();

            } catch(Exception  e) {
                System.out.println("Something went wrong");
                System.out.println(message);
                isSomethingWentWrong = true;
            }
            input.nextLine();
        }
        return line;
    }
}

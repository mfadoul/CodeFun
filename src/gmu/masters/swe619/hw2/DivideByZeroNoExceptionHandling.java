package gmu.masters.swe619.hw2;

import java.util.Scanner;

/**
 * An application that attempts to divide by zero.
 * Step 1: Implement the above code fragment completing the main section
 * based on the comment.
 *
 * @author mfadoul
 * Class: SWE 619
 * Date: 1/30/2010
 */
public class DivideByZeroNoExceptionHandling {

    /**
     * This static method finds the quotient of the input integers.  There is
     * no check to protect against dividing by zero.
     * (demonstrates throwing an exception when a divide-by-zero occurs)
     * 
     * @param numerator
     * @param denominator
     * @return The integer result of numerator/denominator.
     */
    public static int quotient(int numerator, int denominator) {
        return numerator / denominator; // possible division by zero
    }  // end method quotient

    /**
     * This console-based program requests pairs of numbers and computes and
     * displays the quotient of each pair.
     *
     * @param args  Unused commandline options
     */
    public static void main(String args[]) {
        // Provide an implementation to input the numerator, input the denominator
        // call the quotient method, and output the result

        // Use Scanner to read and parse input from System.in.
        Scanner in = new Scanner(System.in);

        // This value will signal that the program should end, based on user input.
        boolean continueDividing = true;

        // Add a small header for each class
        System.out.println("Step 1: " + DivideByZeroNoExceptionHandling.class.toString());
        System.out.println("----------------------------------------------------------");

        while (continueDividing) {
            // Local copies of the numerator, denominator, and answer;
            int numerator;
            int denominator;
            int answer;

            // Input Numerator
            System.out.print("Input Numerator: ");
            numerator = in.nextInt();

            // Input Denominator
            System.out.print("Input Denominator: ");
            denominator = in.nextInt();

            // Calculate the quotient and place it in "answer".
            answer = quotient(numerator, denominator);
            System.out.println(numerator + "/" + denominator + " = " + answer);

            // Allow user to exit the program or continue calculating.
            System.out.print("Continue? (yes/no): ");
            continueDividing = in.next().equalsIgnoreCase("yes");
            
            System.out.println();
        }
        // Close the Scanner
        in.close();

    }  // end main
} // end class


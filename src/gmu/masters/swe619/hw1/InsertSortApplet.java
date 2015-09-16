package gmu.masters.swe619.hw1;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This applet provides a GUI for a user to input arrays of integers.  By pressing
 * the "Sort" button, an ordered permutation of the array will be shown, and the
 * array (both pre- and post-sort) will be recorded in an output file.
 * 
 * @author mfadoul
 * Class: SWE 619
 * Date: 1/25/2010
 */
public class InsertSortApplet extends Applet implements ActionListener {

	private static final long serialVersionUID = 7251295976849080684L;
	
	// These members are GUI Components from AWT
    TextField inputField;
    Label inputLabel;
    Button sortButton;
    Label outputLabel;
    TextField outputField;
    
    // Use this member to write to the output file.
    BufferedWriter outBuffer;

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    @Override
    public void init() {
        // Create and initialize GUI components
        inputLabel = new Label("Input");
        inputField = new TextField("", 35);
        outputLabel = new Label("Output");
        outputField = new TextField("", 35);
        sortButton = new Button("Sort");

        // Add the GUI components to the Applet
        add(inputLabel);
        add(inputField);
        add(outputLabel);
        add(outputField);
        add(sortButton);

        // This allows the Applet to react to the Sort button being pushed.
        sortButton.addActionListener(this);

        // Open a file for writing output text.
        initializeFile();
    }

    /**
     * Initializes a file for writing output text
     */
    private void initializeFile() {
    	// This filename should be changed for non-windows machines.
        String filename = "C:/gmu/swe619_hw1_output.txt";
        File outputFile = new File(filename);

        // If the output file does not exist, this creates a new file.
        if (false == outputFile.exists()) {
            try {
                outputFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(InsertSortApplet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Write some header information in the output file.
        if (outputFile.exists()) {
            outBuffer = null;
            try {
                outBuffer = new BufferedWriter(new FileWriter(outputFile, true));
                outBuffer.write("Output from InsertSortApplet:\n\n");
            } catch (IOException ex) {
                Logger.getLogger(InsertSortApplet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This static method sorts an array of ints.  Note: the
     * method permanently changes the array's contents, and
     * the return array references the same thing as the input
     * parameter.
     *
     * The following is the algorithm from the assignment:
     *      for j <- to length[A]
     *          do key <- A[j]
     *              //Insert A[j] into the sorted sequence A[1...j-1]
     *              I <- J-1
     *              while i>0 and A[i] > key
     *                  do A[i+1] <- A[i]
     *                      i <- i-1
     *              A[i+1] <- key
     *
     * @param   A The input int array that will be sorted.
     * @return  The sorted array of ints.
     */
    static int[] insertionSort(int[] A) {
        for (int j = 1; j < A.length; j++) {
            int key = A[j];
            int i = j - 1;

            while ((i >= 0) && (A[i] > key)) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
        return A;
    }

    /**
     * The only clean-up for the applet is closing the output file.
     */
    @Override
    public void stop() {
        super.stop();
        try {
            // Writes some tail information in the output file.
            outBuffer.write("End of Samples.");
            outBuffer.close();
        } catch (IOException ex) {
            Logger.getLogger(InsertSortApplet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This static method parses any input string and finds an array of ints,
     * using whitespace as the separator.
     *
     * @param inputString
     * @return An array of ints from the string
     */
    public static int[] getIntArrayFromString(String inputString) {
        StringTokenizer st = new StringTokenizer(inputString, " ");

        // Vectors are easier to work with than arrays, so we use this as an
        // intermediate step in building the array.
        Vector<Integer> integerVector = new Vector<Integer>();

        while (st.hasMoreTokens()) {
            integerVector.add(new Integer(st.nextToken()));
        }

        // Convert from Vector of Integers to int array
        int[] intArray = new int[integerVector.size()];

        for (int i = 0; i < integerVector.size(); ++i) {
            intArray[i] = integerVector.elementAt(i).intValue();
        }
        return intArray;
    }

    /**
     * This static method takes an input array of ints and
     * represents them in a String, separated by space characters.
     *
     * @param inputIntArray
     * @return  A string representation of the int array.
     */
    public static String getStringFromIntArray(int[] inputIntArray) {
        StringBuffer outputBuffer = new StringBuffer();

        for (int i = 0; i < inputIntArray.length; ++i) {
            outputBuffer.append(inputIntArray[i]);

            // Add a space after every integer except the last.
            if (i < inputIntArray.length - 1) {
                outputBuffer.append(" ");
            }
        }
        return outputBuffer.toString();
    }

    /**
     * This method listens for GUI events.  A single event (pressing the
     * "Sort" button) is registered in the init() method above.
     *
     * @param e     Used to determine that the source is the Sort Button.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sortButton) {
            String outputString;
            int[] intArray = getIntArrayFromString(this.inputField.getText());

            outputString = "Input Array = {" + getStringFromIntArray(intArray) + "}...";
            intArray = insertionSort(intArray);
            outputString += "Sorted Array = {" + getStringFromIntArray(intArray) + "}\n";

            // This gives the user some feedback in the GUI.
            outputField.setText(getStringFromIntArray(intArray));

            // This writes the array (pre- and post-sort) to the output file
            try {
                outBuffer.write(outputString);
            } catch (IOException ex) {
                Logger.getLogger(InsertSortApplet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Unrecognized Action");
        }
    }
}

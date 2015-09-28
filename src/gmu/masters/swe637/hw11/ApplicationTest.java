/**
 * SWE 637
 * HW 11: Grammar-Based Testing
 * Author: Matthew Fadoul
 */
package gmu.masters.swe637.hw11;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApplicationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("SWE 637, HW 11");
		System.out.println("Author: Matthew Fadoul");
		System.out.println("Description: Grammar-Based Testing");
		System.out.println("---------------------");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("---------------------");
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	    application = new Application();

	    originalStdOut = System.out;
	    originalStdIn  = System.in;
	    
	    baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    // IMPORTANT: Save the old System.out!
	    System.setOut(ps);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	    System.setOut(originalStdOut);
	    System.setIn(originalStdIn);
	    System.out.println("---------");
	}

	
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * Test #1: Base Test
	 */
	@Test
	public void grammarTestBase() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("5\n");
	    inputData.append("This is a test\n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("Test #1: Base Test");
	    originalStdOut.println("Description:");
	    originalStdOut.println("\tThis will be a baseline test.  Its expected output");
	    originalStdOut.println("\twill be used as a comparison for the mutant tests.");
	    originalStdOut.println();
	    originalStdOut.println("Rule:");
	    originalStdOut.println("\tactionWithInput ::= commandLineWithInput validString");
	    originalStdOut.println();
	    originalStdOut.println("Production:");
	    originalStdOut.println("\t5");
	    originalStdOut.println("\tThis is a test");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("THIS IS A TEST\n");
	    expectedOutput.append(applicationInstructions);
	    
	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}
	
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * Test #2: Nonterminal Replacement
	 */
	@Test
	public void grammarTestNonterminalReplacement() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("9\n");
	    inputData.append("This is a test\n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("Test #2: Nonterminal Replacement");
	    originalStdOut.println("Description:");
	    originalStdOut.println("\tThis test replaces the nonterminal �commandLineWithInput� with the");
	    originalStdOut.println("\tnonterminal �commandLineWithoutInput� in the rule for �actionWithInput�.");
	    originalStdOut.println();
	    originalStdOut.println("Rule:");
	    originalStdOut.println("\tactionWithInput ::= commandLineWithInput validString");
	    originalStdOut.println("Mutant:");
	    originalStdOut.println("\tactionWithInput ::= commandLineWithoutInput validString");
	    originalStdOut.println();
	    originalStdOut.println("Production:");
	    originalStdOut.println("\t9");
	    originalStdOut.println("\tThis is a test");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("THIS IS A TEST\n");
	    expectedOutput.append(applicationInstructions);
	    
	    // If false, this kills the mutant
	    assertFalse(expectedOutput.toString().equals(baos.toString()));
	}
	
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * Test #3: Nonterminal Deletion
	 */
	@Test
	public void grammarTestNonterminalDeletion() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("5\n");
	    inputData.append("0\n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("Test #3: Nonterminal Deletion");
	    originalStdOut.println("Description:");
	    originalStdOut.println("\tThis test deletes the nonterminal �validString� in the rule for");
	    originalStdOut.println("\t�actionWithInput�.  Please note: I added an extra ");
	    originalStdOut.println("\t�actionTermination� to prevent the Application.go()");
	    originalStdOut.println("\tmethod from throwing a null pointer exception.");
	    originalStdOut.println();
	    originalStdOut.println("Rule:");
	    originalStdOut.println("\tactionWithInput ::= commandLineWithInput validString");
	    originalStdOut.println("Mutant:");
	    originalStdOut.println("\tactionWithInput ::= commandLineWithInput");
	    originalStdOut.println();
	    originalStdOut.println("Production:");
	    originalStdOut.println("\t5");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("THIS IS A TEST\n");
	    expectedOutput.append(applicationInstructions);
	    	    
	    // If false, this kills the mutant
	    assertFalse(expectedOutput.toString().equals(baos.toString()));
	}
	
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * Test #4: Nonterminal Duplication
	 */
	@Test
	public void grammarTestNonterminalDuplication() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("5\n");
	    inputData.append("This is a test\n");
	    inputData.append("This is a test\n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("Test #4: Nonterminal Duplication");
	    originalStdOut.println("Description:");
	    originalStdOut.println("\tThis test duplicates the nonterminal �validString�");
	    originalStdOut.println("\tin the rule for �actionWithInput�.");
	    originalStdOut.println();
	    originalStdOut.println("Rule:");
	    originalStdOut.println("\tactionWithInput ::= commandLineWithInput validString");
	    originalStdOut.println("Mutant:");
	    originalStdOut.println("\tactionWithInput ::= commandLineWithInput commandLineWithInput validString");
	    originalStdOut.println();
	    originalStdOut.println("Production:");
	    originalStdOut.println("\t5");
	    originalStdOut.println("\tThis is a test");
	    originalStdOut.println("\tThis is a test");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("THIS IS A TEST\n");
	    expectedOutput.append(applicationInstructions);
	    
	    // If false, this kills the mutant
	    assertFalse(expectedOutput.toString().equals(baos.toString()));
	}

	// Class members
	private InputStream originalStdIn;
	private PrintStream originalStdOut;
	private ByteArrayOutputStream baos;
    private Application application;

    public static final String applicationInstructions = "Enter an option:\n" +
            "0: Quit.\n" +
            "1: Break the string into substrings (words) using spaces as separators.\n" +
            "2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
            "3: Invert the String.\n" +
            "4: Count the unique occurances of each word using punctuation and spaces as separators.\n" +
            "5: Convert to uppercase.\n" +
            "6: Convert to lowercase.\n";
    
    public static final String askForStringInstructions = "Enter a string up to 1000 characters:\n";
}


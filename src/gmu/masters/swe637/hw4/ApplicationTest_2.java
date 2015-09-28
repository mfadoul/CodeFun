/**
 * SWE 637
 * HW 9 Extra Credit
 * Author: mfadoul
 */
package gmu.masters.swe637.hw4;

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

public class ApplicationTest_2 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("SWE 637, HW 9: JUnit Extra Credit");
		System.out.println("Author: mfadoul");
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
	 * TEST 0 Base Test {1, "1", FALSE, FALSE, 10}
	 */
	@Test
	public void test0() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("1\n");
	    inputData.append("012345678 \n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("TEST: 0 Base Test {1, \"1\", FALSE, FALSE, 10}");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("012345678\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}
	
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 1 numberOfRuns 0 0 {0, "1", FALSE, FALSE, 10}
	 */
	@Test
	public void test1() {	   
	    originalStdOut.println("TEST: 1	numberOfRuns 0 0 {0, \"1\", FALSE, FALSE, 10}");
		fail("This The following tests cannot be done without changing other characteristics"); 
	}
	
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 2 numberOfRuns 2�MAX_INT 2 {2, \"1\", FALSE, FALSE, 10}
	 */
	@Test
	public void test2() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("1\n");
	    inputData.append("012345678 \n");
	    inputData.append("1\n");
	    inputData.append("012345678 \n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("TEST 2 numberOfRuns 2�MAX_INT 2 {2, \"1\", FALSE, FALSE, 10}");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("012345678\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("012345678\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 3	firstOptionChoice \"0\"	\"0\" {1, \"0\", FALSE, FALSE, 10}
	 */
	@Test
	public void test3() {	   
	    originalStdOut.println("TEST 3	firstOptionChoice \"0\" \"0\" {1, \"0\", FALSE, FALSE, 10}");
		fail("This The following tests cannot be done without changing other characteristics. " 
	    + " This will cause the application to exit before requesting an input string from the user."); 
	}
	
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 4 firstOptionChoice "\2\"	\"2\" {1, \"2\", FALSE, FALSE, 10}
	 */
	@Test
	public void test4() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("2\n");
	    inputData.append("012345678 \n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("TEST 4 firstOptionChoice \"2\" \"2\" {1, \"2\", FALSE, FALSE, 10}");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("Alphabetic: 0\n");
	    expectedOutput.append("Numeric: 9\n");
	    expectedOutput.append("Other: 0\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 5 firstOptionChoice \"3\"	\"3\" {1, \"3\", FALSE, FALSE, 10}
	 */
	@Test
	public void test5() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("3\n");
	    inputData.append("012345678 \n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("TEST 5 firstOptionChoice \"3\" \"3\" {1, \"3\", FALSE, FALSE, 10}");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("\0 876543210\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 6 firstOptionChoice \"4\" \"4\" {1, \"4\", FALSE, FALSE, 10}
	 */
	@Test
	public void test6() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("4\n");
	    inputData.append("012345678 \n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("TEST 6 firstOptionChoice \"4\" \"4\" {1, \"4\", FALSE, FALSE, 10}");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("1 012345678\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);
	    
	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 7 firstOptionChoice \"5\" \"5\" {1, \"5\", FALSE, FALSE, 10}
	 */
	@Test
	public void test7() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("5\n");
	    inputData.append("012345678 \n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("TEST 7 firstOptionChoice \"5\" \"5\" {1, \"5\", FALSE, FALSE, 10}");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("012345678 \n");
	    expectedOutput.append(applicationInstructions);
	    
	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 8 firstOptionChoice \"6\" \"6\" {1, \"6\", FALSE, FALSE, 10}
	 */
	@Test
	public void test8() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("6\n");
	    inputData.append("012345678 \n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("TEST 8 firstOptionChoice \"6\" \"6\" {1, \"6\", FALSE, FALSE, 10}");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("012345678 \n");
	    expectedOutput.append(applicationInstructions);
	    
	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 9 firstOptionChoice MISMATCH	\"7\" {1, \"7\", FALSE, FALSE, 10}
	 */
	@Test
	public void test9() {	   
	    originalStdOut.println("TEST 9 firstOptionChoice MISMATCH \"7\" {1, \"7\", FALSE, FALSE, 10}");
		fail("This The following tests cannot be done without changing other characteristics. " 
	    + " This will cause the application to return to the menu without requesting an input string from the user."); 
	}
	
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 10 firstStringContainsLowerCase TRUE TRUE {1, \"1\", TRUE, FALSE, 10}
	 */
	@Test
	public void test10() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("1\n");
	    inputData.append("abcdefgh \n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("TEST 10 firstStringContainsLowerCase TRUE TRUE {1, \"1\", TRUE, FALSE, 10}");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("abcdefgh\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 11 firstStringContainsUpperCase TRUE TRUE {1, \"1\", FALSE, TRUE 10}
	 */
	@Test
	public void test11() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("1\n");
	    inputData.append("ABCDEFGH \n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("TEST 11 firstStringContainsUpperCase TRUE TRUE {1, \"1\", FALSE, TRUE 10}");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("ABCDEFGH\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 12 firstStringCharacterCount 0	0 {1, \"1\", FALSE, FALSE, 0}
	 */
	@Test
	public void test12() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("1\n");
	    inputData.append("\n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("TEST 12 firstStringCharacterCount 0 0 {1, \"1\", FALSE, FALSE, 0}");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 13 firstStringCharacterCount 1	1 {1, \"1\", FALSE, FALSE, 1}
	 */
	@Test
	public void test13() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("1\n");
	    inputData.append(" \n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("TEST: 13 firstStringCharacterCount 1 1 {1, \"1\", FALSE, FALSE, 1}");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 * TEST 14 firstStringCharacterCount 1001�MAX_INT 1001 {1, \"1\", FALSE, FALSE, 1001}
	 */
	@Test
	public void test14() {
		boolean caughtException = false;
		
		String expectedLongStringOutput;
		
		StringBuffer inputData = new StringBuffer();
	    inputData.append("1\n");
	    {
	    	// Create a string of length 1000
			StringBuffer longStringInput = new StringBuffer();
			for (int i = 0; i < 100; ++i) {
				longStringInput.append("0123456789");
			}
			inputData.append(longStringInput);
		    inputData.append(" \n"); // The space is the 1001st character
		    expectedLongStringOutput = longStringInput.toString();
	    }
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("TEST 14 firstStringCharacterCount 1001�MAX_INT 1001 {1, \"1\", FALSE, FALSE, 1001}");

	    try {
			application.go();
			
		    StringBuffer expectedOutput = new StringBuffer();
		    
		    expectedOutput.append(applicationInstructions);
		    expectedOutput.append(askForStringInstructions);
		    expectedOutput.append(expectedLongStringOutput + "\n");
		    expectedOutput.append("\n");
		    expectedOutput.append(applicationInstructions);
	
		    assertEquals(
		    		expectedOutput.toString(), 
		    		baos.toString()
		    		);
	    } catch (ArrayIndexOutOfBoundsException e) {
	    	caughtException = true;
	    } catch (Exception e) {
	    	caughtException = true;
	    }
	    assertTrue(caughtException);
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


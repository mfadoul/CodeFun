/**
 * SWE 637
 * HW 4
 * Author: mfadoul
 */
package gmu.masters.swe637.hw4;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApplicationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("JUnit Testing for Application Class");
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
	 */
	@Test
	public void testGo0() {
	    StringBuffer inputData = new StringBuffer();
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
		originalStdOut.println("go0 Test Path: ((1,2,3,4,14,21))");
	    originalStdOut.println("  Primary Paths: {(1,2,3,4,14,21)}");
	    originalStdOut.println("  Description: Testing an immediate exit (0)");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}
	
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 */
	@Test
	public void testGo1() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("1\n");
	    inputData.append("a \n");
	    inputData.append("1\n");
	    inputData.append("a \n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("go1 Test Path: (1,2,3,4,5,15,12,2,3,4,5,15,12,2,3,4,14,21)");
	    originalStdOut.println("  Primary Paths: {(2,3,4,5,15,12,2), (5,15,12,2,3,4,14,21)}");
	    originalStdOut.println("  Description: Primary Paths related to substring");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("a\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("a\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 */
	@Test
	public void testGo2() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("2\n");
	    inputData.append("1a~\n");
	    inputData.append("2\n");
	    inputData.append("1a~\n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("go2 Test Path: (1,2,3,4,5,6,16,12,2,3,4,5,6,16,12,2,3,4,14,21)");
	    originalStdOut.println("  Primary Paths: {(2,3,4,5,6,16,12,2), (5,6,16,12,2,3,4,14,21)}");
	    originalStdOut.println("  Description: Primary Paths related to charCount");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("Alphabetic: 1\n");
	    expectedOutput.append("Numeric: 1\n");
	    expectedOutput.append("Other: 1\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("Alphabetic: 1\n");
	    expectedOutput.append("Numeric: 1\n");
	    expectedOutput.append("Other: 1\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}
	
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 */
	@Test
	public void testGo3() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("3\n");
	    inputData.append("ab\n");
	    inputData.append("3\n");
	    inputData.append("ab\n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("go3 Test Path: (1,2,3,4,5,6,7,17,12,2,3,4,5,6,7,17,12,2,3,4,14,21)");
	    originalStdOut.println("  Primary Paths: {(2,3,4,5,6,7,17,12,2), (5,6,7,17,12,2,3,4,14,21)}");
	    originalStdOut.println("  Description: Primary Paths related to invert");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("\0ba");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("\0ba");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}
	
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 */
	@Test
	public void testGo4() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("4\n");
	    inputData.append("abc abc\n");
	    inputData.append("4\n");
	    inputData.append("abc abc\n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("go4 Test Path: (1,2,3,4,5,6,7,8,18,12,2,3,4,5,6,7,8,18,12,2,3,4,14,21)");
	    originalStdOut.println("  Primary Paths: {(2,3,4,5,6,7,8,18,12,2), (5,6,7,8,18,12,2,3,4,14,21)}");
	    originalStdOut.println("  Description: Primary Paths related to uniqueOccurences");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("2 abc\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("2 abc\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}
	
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 */
	@Test
	public void testGo5() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("5\n");
	    inputData.append("aA\n");
	    inputData.append("5\n");
	    inputData.append("aA\n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("go5 Test Path: (1,2,3,4,5,6,7,8,9,19,12,2,3,4,5,6,7,8,9,19,12,2,3,4,14,21)");
	    originalStdOut.println("  Primary Paths: {(2,3,4,5,6,7,8,9,19,12,2), (5,6,7,8,9,19,12,2,3,4,14,21)}");
	    originalStdOut.println("  Description: Primary Paths related to toUpperCase");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("AA");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("AA");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 */
	@Test
	public void testGo6() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("6\n");
	    inputData.append("aA\n");
	    inputData.append("6\n");
	    inputData.append("aA\n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("go6 Test Path: (1,2,3,4,5,6,7,8,9,10,20,12,2,3,4,5,6,7,8,9,10,20,12,2,3,4,14,21)");
	    originalStdOut.println("  Primary Paths: {(2,3,4,5,6,7,8,9,10,20,12,2), (5,6,7,8,9,10,20,12,2,3,4,14,21)}");
	    originalStdOut.println("  Description: Primary Paths related to toLowerCase");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("aa");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append(askForStringInstructions);
	    expectedOutput.append("aa");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}
	/**
	 * Test method for {@link stringPlay.Application#go()}.
	 */
	@Test
	public void testGo7() {
		StringBuffer inputData = new StringBuffer();
	    inputData.append("7\n");
	    inputData.append("7\n");
	    inputData.append("0\n");

	    String str = inputData.toString();

		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
		System.setIn(is);
	   
	    originalStdOut.println("go7 Test Path: (1,2,3,4,5,6,7,8,9,10,11,12,2,3,4,5,6,7,8,9,10,11,12,2,3,4,14,21)");
	    originalStdOut.println("  Primary Paths: {(2,3,4,5,6,7,8,9,10,11,12,2), (5,6,7,8,9,10,11,12,2,3,4,14,21)}");
	    originalStdOut.println("  Description: Primary Paths related to mismatch selections");

		application.go();
		
	    StringBuffer expectedOutput = new StringBuffer();
	    
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append("Enter option 1-6, or 0 to quit.\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);
	    expectedOutput.append("Enter option 1-6, or 0 to quit.\n");
	    expectedOutput.append("\n");
	    expectedOutput.append(applicationInstructions);

	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}
	
	/**
	 * Test method for {@link stringPlay.Application#askForString(java.io.BufferedReader)}.
	 */
	@Test
	public void testGo_IOExceptionHandling() {		
	    originalStdOut.println("go_IOExceptionHandling:");
	    originalStdOut.println("  Primary Paths Pairs {");
	    originalStdOut.println("    (1,2,3,13,21),");
	    originalStdOut.println("    (4,5,15,12,2,3,13,21),");
	    originalStdOut.println("    (4,5,6,16,12,2,3,13,21),");
	    originalStdOut.println("    (4,5,6,7,17,12,2,3,13,21),");
	    originalStdOut.println("    (4,5,6,7,8,18,12,2,3,13,21),");
	    originalStdOut.println("    (4,5,6,7,8,9,19,12,2,3,13,21),");
	    originalStdOut.println("    (4,5,6,7,8,9,10,20,12,2,3,13,21),");
	    originalStdOut.println("    (4,5,6,7,8,9,10,11,12,2,3,13,21)");
	    originalStdOut.println("    }");
	    originalStdOut.println("  Description: Primary Paths with IOExceptions are not currently tested.");

	    // TODO: Handle the case of an IOExeption.
		fail("Handling IOExeption is not yet implemented"); 
	}

    /**
	 * Test method for {@link stringPlay.Application#askForString(java.io.BufferedReader)}.
	 */
	@Test
	public void testAskForString1() {
		String str = "a\n";
		 
		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
	 
		// read it with BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

	    originalStdOut.println("askForString1 Path: (1,2,3,7)");
	    originalStdOut.println("  Edge Pairs: {(1,2,3), (2,3,7)}");
		String result = application.askForString(br);
		
	    System.out.flush();
	    assertEquals(
	    		"Enter a string up to 1000 characters:\n", 
	    		baos.toString()
	    		);
	    assertEquals(
	    		"a", 
	    		result
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#askForString(java.io.BufferedReader)}.
	 */
	@Test
	public void testAskForString2() {
		String str;
		String expectedResult;
		{
			// Create a string larger than the Max 1000 character limit.
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 2001; ++i) {
				sb.append("0");
			}
			expectedResult = sb.toString();
			sb.append("\n");

			str=sb.toString();
		}
		
		// convert String into InputStream
		InputStream is = new ByteArrayInputStream(str.getBytes());
	 
		// read it with BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

	    originalStdOut.println("askForString2 Path: (1,2,3,4,5,7)");
	    originalStdOut.println("  Edge Pairs: {(1,2,3), (2,3,4), (3,4,5), (4,5,7)}");
	    
	    //boolean caughtException = false;
	    String result = "";
	    
	    result = application.askForString(br);

	    System.out.flush();

	    assertEquals(
	    		"Enter a string up to 1000 characters:\n", 
	    		baos.toString()
	    		);
	    assertEquals(
	    		expectedResult, 
	    		result
	    		);
	}
	
	/**
	 * Test method for {@link stringPlay.Application#askForString(java.io.BufferedReader)}.
	 */
	@Test
	public void testAskForString_IOExceptionHandling() {		
	    originalStdOut.println("askForString3 Path: (1,2,6,7)");
	    originalStdOut.println("  Edge Pairs: {(1,2,6), (2,6,7)}");
	    
	    // TODO: Handle the case of an IOExeption.
		fail("Handling IOExeption is not yet implemented"); 
	}

	/**
	 * Test method for {@link stringPlay.Application#subString(java.lang.String)}.
	 */
	@Test
	public void testSubString1() {
	    originalStdOut.println("supString1 Path: (1,2,7)");
	    originalStdOut.println("  Edge Pairs: {(1,2,7)}");
		application.subString("");
		
	    System.out.flush();
	    assertEquals(
	    		"", 
	    		baos.toString()
	    		);
	}
	
	/**
	 * Test method for {@link stringPlay.Application#subString(java.lang.String)}.
	 */
	@Test
	public void testSubString2() {
	    originalStdOut.println("supString2 Path: (1,2,3,5,6,2,3,4,6,2,7)");
	    originalStdOut.println("  Edge Pairs: {{(1,2,3), (2,3,4), (2,3,5), (3,4,6), (3,5,6), (4,6,2), (5,6,2), (6,2,3), (6,2,7)}}");
		application.subString("a ");
		
	    System.out.flush();
	    assertEquals(
	    		"a\n", 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#charCount(java.lang.String)}.
	 */
	@Test
	public void testCharCount1() {
	    originalStdOut.println("charCount1 Path: (1,2,9)");
	    originalStdOut.println("  Edge Pairs: {(1,2,9)}");
		application.charCount("");
		
	    System.out.flush();
	    
	    StringBuffer expectedOutput = new StringBuffer();
	    expectedOutput.append("Alphabetic: 0\n");
	    expectedOutput.append("Numeric: 0\n");
	    expectedOutput.append("Other: 0\n");
	   
	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}
	
	/**
	 * Test method for {@link stringPlay.Application#charCount(java.lang.String)}.
	 */
	@Test
	public void testCharCount2() {
	    originalStdOut.println("charCount2 Path: (1,2,3,4,8,2,3,5,6,8,2,3,5,7,8,2,9)");
	    originalStdOut.println("  Edge Pairs: {(1,2,3), (2,3,4), (2,3,5), (3,4,8), (3,5,6), (3,5,7),");
	    originalStdOut.println("    (4,8,2), (5,6,8), (5,7,8), (6,8,2), (7,8,2), (8,2,3), (8,2,9)}");
		application.charCount("1a~");
		
	    System.out.flush();
	    
	    StringBuffer expectedOutput = new StringBuffer();
	    expectedOutput.append("Alphabetic: 1\n");
	    expectedOutput.append("Numeric: 1\n");
	    expectedOutput.append("Other: 1\n");
	   
	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#invert(java.lang.String)}.
	 */
	@Test
	public void testInvert1() {
	    originalStdOut.println("invert1 Path: (1,2,5)");
	    originalStdOut.println("  Edge Pairs: {(1,2,5)}");
		application.invert("");
		
	    System.out.flush();
	    assertEquals(
	    		"\0", 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#invert(java.lang.String)}.
	 */
	@Test
	public void testInvert2() {
	    originalStdOut.println("invert2 Path: (1,2,3,4,2,3,4,2,5)");
	    originalStdOut.println("  Edge Pairs: {(1,2,3), (1,2,5), (2,3,4), (3,4,2), (4,2,3), (4,2,5)}");
		application.invert("ab");
		
	    System.out.flush();
	    assertEquals(
	    		"\0ba",
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#toUppercase(java.lang.String)}.
	 */
	@Test
	public void testToUppercase1() {
		// {(1,2,8)}
	    originalStdOut.println("toUpperCase1 Path: (1,2,8)");
	    originalStdOut.println("  Edge Pairs: {(1,2,8)}");
		application.toUppercase("");
		
	    System.out.flush();
	    assertEquals(
	    		"", 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#toUppercase(java.lang.String)}.
	 */
	@Test
	public void testToUppercase2() {
		// {(1,2,3), (2,3,4), (3,4,7), (3,4,6), (4,6,7), (4,7,2), (6,7,2), (7,2,3), (7,2,8)}
	    originalStdOut.println("toUpperCase2 Path: (1,2,3,4,6,7,2,3,4,7,2,8)");
	    originalStdOut.println("  Edge Pairs: {(1,2,3), (2,3,4), (3,4,7), (3,4,6), (4,6,7), (4,7,2), (6,7,2), (7,2,3), (7,2,8)}");
		application.toUppercase("a~");
		
	    System.out.flush();
	    assertEquals(
	    		"A", 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#uniqueOccurrences(java.lang.String)}.
	 */
	@Test
	public void testUniqueOccurrences1() {
	    originalStdOut.println("uniqueOccurrences1 Test Path: (1,2,3,4,6,2,3,5,6,2,3,4,6,2,7,8,9,10,8,9,10,11)");
	    originalStdOut.println("  Primary Paths: {(1,2,3,4,6), (2,3,4,6,2), (2,3,5,6,2), (3,4,6,2,7,8,9,10), (5,6,2,3,4), (8,9,10,8), (9,10,8,11)}");

	    application.uniqueOccurrences("aaa aaa bbb");

	    StringBuffer expectedOutput = new StringBuffer();
	    expectedOutput.append("2 aaa\n");
	    expectedOutput.append("1 bbb\n");

	    System.out.flush();
	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#uniqueOccurrences(java.lang.String)}.
	 */
	@Test
	public void testUniqueOccurrences2() {
	    originalStdOut.println("uniqueOccurrences2 Test Path: (1,2,3,4,6,2,3,5,6,2,7,8,9,10,8,11)");
	    originalStdOut.println("  Primary Paths: { (3,5,6,2,7,8,9,10), (4,6,2,3,5)}");

	    application.uniqueOccurrences("abc abc");

	    StringBuffer expectedOutput = new StringBuffer();
	    expectedOutput.append("2 abc\n");

	    System.out.flush();
	    assertEquals(
	    		expectedOutput.toString(), 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link stringPlay.Application#uniqueOccurrences(java.lang.String)}.
	 */
	@Test
	public void testUniqueOccurrences3() {
	    originalStdOut.println("uniqueOccurrences3: ");
	    originalStdOut.println("  The following Primary Paths are semantically impossible:");
	    originalStdOut.println("  Primary Paths: {(1,2,7,8,11), (1,2,3,5,6), (1,2,7,8,9,10), (3,4,6,2,7,8,11), (3,5,6,2,7,8,11)}");
	}

	/**
	 * Test method for {@link stringPlay.Application#toLowercase(java.lang.String)}.
	 */
	@Test
	public void testToLowercase1() {
	    originalStdOut.println("toLowerCase1 Path: (1,2,8)");
	    originalStdOut.println("  Edge Pairs: {(1,2,8)}");
		application.toLowercase("");
		
	    System.out.flush();
	    assertEquals(
	    		"", 
	    		baos.toString()
	    		);
	}
	/**
	 * Test method for {@link stringPlay.Application#toLowercase(java.lang.String)}.
	 */
	@Test
	public void testToLowercase2() {
	    originalStdOut.println("toLowerCase2 Path: (1,2,3,4,5,7,2,3,4,6,7,2,8)");
	    originalStdOut.println("  Edge Pairs: {(1,2,3), (2,3,4), (3,4,5), (3,4,6), (4,5,7), (4,6,7), (5,7,2), (6,7,2), (7,2,3), (7,2,8)}");
		application.toLowercase("aA");
		
	    System.out.flush();
	    assertEquals(
	    		"aa", 
	    		baos.toString()
	    		);
	}
	
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

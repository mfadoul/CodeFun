/**
 * JUnit test class for Fraction
 * @author mfadoul
 * SWE 637
 * 9/16/2012
 */
package gmu.masters.swe637.hw2;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Test class 
 */
public class FractionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link Fraction#GetNumFracs()}.
	 */
	@Test
	public void testGetNumFracs() {
		int initialNumFracs = Fraction.GetNumFracs();
		Fraction aFraction = new Fraction();
		int finalNumFracs = Fraction.GetNumFracs();

		// Confirm that the number of fractions increments by one 
		// when creating a new fraction.
		assertEquals (initialNumFracs+1, finalNumFracs);
	}

	/**
	 * Test method for {@link Fraction#Fraction()}.
	 */
	@Test
	public void testFraction() {
		// For constructor without parameters
		Fraction aFraction = new Fraction();
		assertEquals("0 / 1", aFraction.toString());
	}

	/**
	 * Test method for {@link Fraction#Fraction(int, int)}.
	 */
	@Test
	public void testFractionIntInt() {
		Fraction aFraction = new Fraction(3, 5);
		assertEquals("3 / 5", aFraction.toString());
	}

	/**
	 * Test method for {@link Fraction#Fraction(boolean)}.
	 */
	@Test
	public void testFractionBoolean() {
		Fraction aFraction = new Fraction();
		assertEquals("0 / 1", aFraction.toString());
	}

	/**
	 * Test method for {@link Fraction#Add(Fraction)}.
	 */
	@Test
	public void testAdd() {
		// Test with common denominator
		Fraction fraction1 = new Fraction(1, 5);
		Fraction fraction2 = new Fraction(3, 5);
		
		Fraction fraction3 = new Fraction(1, 2);
		Fraction fraction4 = new Fraction(3, 5);
		
		fraction1.Add(fraction2);
		assertEquals ("4 / 5", fraction1.toString());
		
		// Test without common denominator results in an exception		
		
		// The code for manipulating the stdout is from the Internet.
	    // Create a stream to hold the output
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    // IMPORTANT: Save the old System.out!
	    PrintStream old = System.out;
	    // Tell Java to use your special stream
	    System.setOut(ps);
	    
	    // This will cause an error to be printed to stdout
		fraction3.Add(fraction4);

	    // Put things back
	    System.out.flush();
	    System.setOut(old);
	    
	    assertEquals(
	    		"Fraction add error: Denominators must be the same.\n", 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link Fraction#Multiply(Fraction)}.
	 */
	@Test
	public void testMultiply() {
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fraction2 = new Fraction(3, 5);
		fraction1.Multiply(fraction2);
		
		assertEquals("3 / 10", fraction1.toString());
	}

	/**
	 * Test method for {@link Fraction#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fraction2 = new Fraction(1, 2);
		Fraction fraction3 = new Fraction(1, 3);
		
		assertTrue (fraction1.equals(fraction2));
		
		assertFalse(fraction1.equals(fraction3));
		
		// TODO: Fix equals method so it handles comparisons of 
		// fractions like 1/2 and 2/4.
	}

	/**
	 * Test method for {@link Fraction#clone()}.
	 */
	@Test
	public void testClone() {
		Fraction fraction1 = new Fraction(1, 2);
		Object fraction2 = fraction1.clone();
		
		// Assert that the returned object is in fact an instance of Fraction
		assertTrue (Fraction.class.isInstance(fraction2));
		
		// Assert that the clone is not a reference to the same object.
		assertNotSame(fraction1, fraction2);
		
		// Assert that the value of fraction2 is correct
		assertEquals("1 / 2", fraction2.toString());
	}

	/**
	 * Test method for {@link Fraction#PrintFrac()}.
	 */
	@Test
	public void testPrintFrac() {
		Fraction fraction1 = new Fraction(1, 2);

		// The code for manipulating the stdout is from the Internet.
	    // Create a stream to hold the output
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    // IMPORTANT: Save the old System.out!
	    PrintStream old = System.out;
	    // Tell Java to use your special stream
	    System.setOut(ps);
	    
	    // This will cause an error to be printed to stdout
		fraction1.PrintFrac();
		
	    // Put things back
	    System.out.flush();
	    System.setOut(old);
	    
	    assertEquals(
	    		"1 / 2\n", 
	    		baos.toString()
	    		);
	}

	/**
	 * Test method for {@link Fraction#toString()}.
	 */
	@Test
	public void testToString() {
		Fraction fraction1 = new Fraction(1, 2);
		assertEquals("1 / 2", fraction1.toString());
	}

}

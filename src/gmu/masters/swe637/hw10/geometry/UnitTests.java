/**
 * 
 */
package gmu.masters.swe637.hw10.geometry;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author mfadoul
 *
 * Mutants:
 * 1) OMD: Overriding Method Deletion--Each entire declaration of an overriding method is deleted.
 * 2) PCD: Parent Constructor Deletion--Each call to a super constructor is deleted.
 */
public class UnitTests {
	// Delta value for comparisons of type double
	private double delta = 0.01;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("mfadoul");
		System.out.println("SWE 637: Homework 10");
		System.out.println("December 2, 2012");
		System.out.println();
		System.out.println("JUnit Test Results for Object-Oriented Mutations");
		System.out.println("------------------------------------------------");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

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
		System.out.println("--------------------");
	}

	/**
	 * Test method for {@link swe637.geometry.original.LineSegment2D#getLength()}.
	 */
	@Test
	public final void testOriginalLineSegment2D() {
		System.out.println("Testing swe637.geometry.original.LineSegment2D");
		System.out.println("Description: Confirm that the original LineSegment2D");
		System.out.println("  class functions as expected.");
		System.out.println();
		gmu.masters.swe637.hw10.geometry.original.LineSegment2D lineSegment2D = 
				new gmu.masters.swe637.hw10.geometry.original.LineSegment2D(1.0, 4.0, 2.0, 6.0);
		double expectedValue = 5.0;
		
		System.out.println(lineSegment2D.getSummaryString());
		System.out.println("* Calculated Length=" + lineSegment2D.getLength());
		System.out.println("* Expected Length=" + expectedValue);
		
		assertEquals(expectedValue, lineSegment2D.getLength(), delta);
	}

	/**
	 * Test method for {@link swe637.geometry.original.LineSegment3D#getLength()}.
	 */
	@Test
	public final void testOriginalLineSegment3D() {
		System.out.println("Testing swe637.geometry.original.LineSegment3D");
		System.out.println("Description: Confirm that the original LineSegment3D");
		System.out.println("  class functions as expected.");
		System.out.println();

		gmu.masters.swe637.hw10.geometry.original.LineSegment3D lineSegment3D = 
				new gmu.masters.swe637.hw10.geometry.original.LineSegment3D(1.0, 4.0, 2.0, 6.0, 0.0, 12.0);
		double expectedValue = 13.0;
		
		System.out.println(lineSegment3D.getSummaryString());
		System.out.println("* Calculated Length=" + lineSegment3D.getLength());
		System.out.println("* Expected Length=" + expectedValue);
		
		assertEquals(expectedValue, lineSegment3D.getLength(), delta);
	}
	
	/**
	 * Test method for {@link swe637.geometry.omd.LineSegment3D#getLength()}.
	 */
	@Test
	public final void testOmdLineSegment3D() {
		System.out.println("Testing swe637.geometry.omd.LineSegment3D");
		System.out.println("Description: This test uses a mutated class");
		System.out.println("  based on the OMD Mutation Operator. ");
		System.out.println("  Without the overriding method, the length");
		System.out.println("  will be calculated based on the X and Y ");
		System.out.println("  values, and ignore the Z values.");
		System.out.println();
		gmu.masters.swe637.hw10.geometry.omd.LineSegment3D omdLineSegment3D = 
				new gmu.masters.swe637.hw10.geometry.omd.LineSegment3D(1.0, 4.0, 2.0, 6.0, 0.0, 12.0);
		
		gmu.masters.swe637.hw10.geometry.original.LineSegment3D originalLineSegment3D = 
				new gmu.masters.swe637.hw10.geometry.original.LineSegment3D(1.0, 4.0, 2.0, 6.0, 0.0, 12.0);
		double expectedValue = originalLineSegment3D.getLength();
		
		System.out.println("Original     = " + originalLineSegment3D.getSummaryString());
		System.out.println("OMD Mutation = " + omdLineSegment3D.getSummaryString());
				
		assertFalse( Math.abs(expectedValue - omdLineSegment3D.getLength()) < delta);
	}
	
	/**
	 * Test method for {@link swe637.geometry.pcd.LineSegment3D#getLength()}.
	 */
	@Test
	public final void testPcdLineSegment3D() {
		System.out.println("Testing swe637.geometry.pcd.LineSegment3D");
		System.out.println("Description: This test uses a mutated class");
		System.out.println("  based on the PCD Mutation Operator. ");
		System.out.println("  By commenting out the reference to the parent");
		System.out.println("  constructor, the X and Y values are not ");
		System.out.println("  properly initialized.  As a result,");
		System.out.println("  calls to X/Y getters, getLength()");
		System.out.println("  and getSummaryString() will return incorrect values.");
		System.out.println();
		
		gmu.masters.swe637.hw10.geometry.pcd.LineSegment3D pcdLineSegment3D = 
				new gmu.masters.swe637.hw10.geometry.pcd.LineSegment3D(1.0, 4.0, 2.0, 6.0, 0.0, 12.0);
		
		gmu.masters.swe637.hw10.geometry.original.LineSegment3D originalLineSegment3D = 
				new gmu.masters.swe637.hw10.geometry.original.LineSegment3D(1.0, 4.0, 2.0, 6.0, 0.0, 12.0);
		double expectedValue = originalLineSegment3D.getLength();
		
		System.out.println("Original     = " + originalLineSegment3D.getSummaryString());
		System.out.println("PCD Mutation = " + pcdLineSegment3D.getSummaryString());
		
		assertFalse( Math.abs(expectedValue - pcdLineSegment3D.getLength()) < delta);
		assertFalse( pcdLineSegment3D.getSummaryString().equals(originalLineSegment3D.getSummaryString()));
		
	}
}

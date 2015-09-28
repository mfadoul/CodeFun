package gmu.masters.swe637.hw10.geometry.pcd;

import gmu.masters.swe637.hw10.geometry.original.LineSegment2D;

/**
 * @author mfadoul
 * @course SWE 637
 * @date 12/2/2012
 *  
 * @description This immutable class stores coordinates for a 3D line segment.
 *   It allows clients to query the coordinates, and obtain the length of the
 *   line segment.
 *   
 *   Mutation: 
 *   PCD (Parent Constructor Deletion)
 *   Each call to a super constructor is deleted.
 *   
 *   For this mutation, the reference to the super constructor is removed.
 */

public class LineSegment3D extends LineSegment2D {

	protected double z1;
	protected double z2;

	/**
	 * Constructor
	 * 
	 * @param x1 The X coordinate of the first point in the line segment
	 * @param x2 The X coordinate of the second point in the line segment
	 * @param y1 The Y coordinate of the first point in the line segment
	 * @param y2 The Y coordinate of the second point in the line segment
	 * @param z1 The Z coordinate of the first point in the line segment
	 * @param z2 The Z coordinate of the second point in the line segment
	 */
	public LineSegment3D(double x1, double x2, double y1, double y2, double z1, double z2) {
		// PCD Mutation
		// Parent Constructor Deletion--Each call to a super constructor is deleted.
		
		// super(x1, x2, y1, y2);

		this.z1 = z1;
		this.z2 = z2;
	}
	
	// Getters
	public double getZ1() { return z1; }
	public double getZ2() { return z2; }

	/**
	 * 
	 * @return The length of the 3D line segment
	 */
	@Override
	public double getLength() {
		return Math.sqrt(
			Math.pow(z2-z1, 2.0) +
			Math.pow(super.getLength(),2.0)
			);
	}
	
	/**
	 * 
	 * @return A Human-readable string that summarizes information 
	 *   related to the 3D LineSegment.
	 */
	@Override
	public String getSummaryString() {
		String string = "LineSegment2D { x=" + (x2-x1) + 
				", y=" + (y2-y1) + 
				", z=" + (z2-z1) + 
				", length=" + getLength() + "}";
		return string;
	}
}
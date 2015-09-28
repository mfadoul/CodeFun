package gmu.masters.swe637.hw10.geometry.original;

/**
 * @author mfadoul
 * @course SWE 637
 * @date 12/2/2012
 * 
 * @description This immutable class stores coordinates for a 2D line segment.
 *   It allows clients to query the coordinates, and obtain the length of the
 *   line segment.
 */

public class LineSegment2D {
	protected final double x1;
	protected final double x2;
	protected final double y1;
	protected final double y2;
	
	/**
	 * Constructor (Default with no arguments)
	 * 
	 */
	public LineSegment2D () {
		this.x1 = 0.0;
		this.x2 = 0.0;
		this.y1 = 0.0;
		this.y2 = 0.0;
	}
	
	/**
	 * Constructor
	 * 
	 * @param x1 The X coordinate of the first point in the line segment
	 * @param x2 The X coordinate of the second point in the line segment
	 * @param y1 The Y coordinate of the first point in the line segment
	 * @param y2 The Y coordinate of the second point in the line segment
	 */
	public LineSegment2D (double x1, double x2, double y1, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	// Getters
	public double getX1() {	return x1; }
	public double getX2() { return x2; }
	public double getY1() { return y1; }
	public double getY2() { return y2; }

	/**
	 * 
	 * @return The length of the 2D line segment
	 */
	public double getLength () {
		return Math.sqrt(
			Math.pow((x2-x1),2.0) +
			Math.pow((y2-y1),2.0)
			);
	}
	
	/**
	 * 
	 * @return A Human-readable string that summarizes information 
	 *   related to the 2D LineSegment.
	 */
	public String getSummaryString() {
		String string = "LineSegment2D { x=" + (x2-x1) + 
				", y=" + (y2-y1) + 
				", length=" + getLength() + "}";
		return string;
	}
}

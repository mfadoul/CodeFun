package com.my3d.dailycoding;

import java.util.Vector;

/*
Given an array of integers, find the first missing positive integer in linear time and constant space. 
In other words, find the lowest positive integer that does not exist in the array. The array can contain 
duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.


 */
public class DailyCoding04 {

	static int getLowestPosIntNonExist(Vector<Integer> integerArray) {
		// Limit to worrying about values between 1 and the size of the array.

		boolean hasMaxValue = false;
		
		// Linear time #1
		for (int i = 0; i < integerArray.size(); ++i) {
			Integer currentValue = integerArray.get(i);
			if (currentValue == integerArray.size()) {
				hasMaxValue = true;
				integerArray.set(i, 0);
			} else if (currentValue < 1 || currentValue > integerArray.size()) {
				integerArray.set(i, 0);
			} else {
				if (currentValue != i) {
					// Swap values for the resultant entry
					//integerArray.setSize(i, );
					//System.in.
				}
			}

			// 1) If the current value is less than 1 or greater than or equal to size of array,
		    // then set the current value to 0.
			// 2) Else If the current value is equal to the current index, set the value.
			// 3)      Else swap with the contents of the value 
			
		}
		
		// Linear time #1
		Integer lowestPosInt = Integer.MAX_VALUE;
		for (Integer currentValue: integerArray) {
			if (lowestPosInt > currentValue) {
				lowestPosInt = currentValue;
			}
		}
		System.out.println("Lowest positive value = " + lowestPosInt);
		
		// Linear time #2
		Integer secondLowestPosInt = Integer.MAX_VALUE;
		for (Integer currentValue: integerArray) {
			if ((secondLowestPosInt > currentValue) && (currentValue != lowestPosInt)){
				secondLowestPosInt = currentValue;
			}
		}
		System.out.println("Second Lowest positive value = " + secondLowestPosInt);

		// This doesn't work!!!
		
		// TODO...keep on thinking!!!!

		return 0;
	}
	
	public DailyCoding04() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

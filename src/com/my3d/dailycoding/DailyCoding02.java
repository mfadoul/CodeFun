package com.my3d.dailycoding;

import java.util.Vector;

/*
Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

 */
public class DailyCoding02 {

	public DailyCoding02() {


	}

	static Vector<Integer> getProductArray (final Vector<Integer> inputArray) {
		Integer previousEntriesProduct = new Integer(1);
		Integer futureEntriesProduct = new Integer(1);
		Vector<Integer> returnValue = new Vector<Integer>();
		
		if (inputArray.contains(0)) {
			System.err.println("Detected zero value.  Don't want to divide by zero");
			return returnValue;
		}
		//Populate futures
		for (Integer currentInt: inputArray) {
			futureEntriesProduct *= currentInt;
		}
		
		
		for (Integer currentInt: inputArray) {
			futureEntriesProduct /= currentInt;
			returnValue.add(previousEntriesProduct * futureEntriesProduct);
			previousEntriesProduct *= currentInt;

		}

		return returnValue;
	}
	
	public static void main(String[] args) {
		Vector<Integer> inputArray1 = new Vector<Integer>();
		Vector<Integer> outputArray1;
		inputArray1.add(0);
		inputArray1.add(5);
		inputArray1.add(8);
		inputArray1.add(10);

		outputArray1 = getProductArray(inputArray1);
		
		System.out.println("Output Array 1");
		for (Integer currentInt: outputArray1) {
			System.out.println("Value = " + currentInt);
		}

	}

}

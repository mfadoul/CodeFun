package com.my3d.dailycoding;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DailyCoding01 {

	public static boolean hasSumOfK_1 (List<Integer> listOfNumbers, int k) {
		Set<Integer> testSet = new HashSet<Integer>();
		
		for (Integer intValue: listOfNumbers) {
			if (testSet.contains(k - intValue)) {
				// Found a match
				return true;
			} else {
				testSet.add(intValue);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// Test case #1
		int k = 17;
		List<Integer> testCase1 = new LinkedList<Integer>();
		List<Integer> testCase2 = new LinkedList<Integer>();

		testCase1.add(1);
		testCase1.add(4);
		testCase1.add(7);
		testCase1.add(8);
		testCase1.add(10);
		testCase1.add(15);

		testCase2.add(1);
		testCase2.add(2);
		testCase2.add(3);
		testCase2.add(4);
		testCase2.add(5);
		testCase2.add(6);

		System.out.println ("Test Case #1");
		if (hasSumOfK_1(testCase1, k)) {
			System.out.println("Found duplicate");
		} else {
			System.out.println("No duplicate");		
		}

		System.out.println ("Test Case #2");
		if (hasSumOfK_1(testCase2, k)) {
			System.out.println("Found duplicate");
		} else {
			System.out.println("No duplicate");		
		}


	}

}

package com.my3d.dailycoding;

import java.util.Set;
import java.util.Vector;

/*
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
 */

public class DailyCoding07 {

	public DailyCoding07() {
		// TODO Auto-generated constructor stub
	}
	
	static int getNumberOfDecodedWays(String s) {
		int returnValue;
		
		//System.out.println("Checking string = " + s);
		if (s.length() == 0) {
			//System.out.println("---A---");
			return 1;
		}
		
		if (s.charAt(0) == '0') {
			//System.out.println("---B---");
			return 0;
		}
		
		if (s.length() == 1) {
			//System.out.println("---C---");
			return 1;
		}
		
		Integer frontTwoInteger = new Integer(s.substring(0, 2));
		//System.out.print("FrontTwo = " + frontTwoInteger);
		if (frontTwoInteger <= 26) {
			// Two ways
			//System.out.println("...Two ways");
			returnValue = 
					getNumberOfDecodedWays(s.substring(1)) +
					getNumberOfDecodedWays(s.substring(2));
		} else {
			// Only one way
			//System.out.println("...One way");
			returnValue = 
					getNumberOfDecodedWays(s.substring(1));
		}
		//System.out.println("  Recursive return = " + returnValue);
		return (returnValue);

	}

	public static void main(String[] args) {
		Vector<String> testCases = new Vector<String>();
		testCases.add("111");
		testCases.add("1111");
		testCases.add("1191");
		testCases.add("1901");
				
		for (String testCase: testCases) {
			System.out.println("Test case    = " + testCase);
			System.out.println("Return Value = " + getNumberOfDecodedWays(testCase));
			System.out.println();
		}
	}

}

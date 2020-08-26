package com.revature.tier1;

public class NumberSumLength {

	public static boolean checkNumberPowerLength(long num) {
		if (num != 0) {
			int result = 0; 
			int length = Long.toString(num).length();
			
			for (int i = 0; i < length; ++i) {
				int n = Long.toString(num).indexOf(i);
				result += (n * n);
			}
			
			if (result == num) {
				return true;
			}
		}
		return false;
	}
}

package com.revature.tier1;

public class SumOverArray {

	public static int IterateAndSum(int[] arr) {
		if (arr != null) {
			int total = 0;
			for (int i = 0; i < arr.length; ++i) {
				int item = arr[i];
				total += item;
			}
			return total;
		} else {
			return 0;
		}
	}
}

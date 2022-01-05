package array2;

public class FindMinimumAndMaximumInAnArray {
	//Time Complexity : O(n), where n is the length of arr
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int[] findMinMax1(int[] arr) {
		int[] res = new int[2];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < min)
				min = arr[i];
			if(arr[i] > max)
				max = arr[i];
		}
		
		res[0] = min;
		res[1] = max;
		
		return res;
	}
}

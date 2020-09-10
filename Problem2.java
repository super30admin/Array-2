Time Complexity: O(n)
Space Complexity: Constant


public class Solution {
	public void findMinMax(int[] arr) {
		int prev_min = Integer.MAX_VALUE;
		int prev_max = Integer.MIN_VALUE;
		
		for(int i = 0; (i + 1) < arr.length; i += 2) {
			int curr_min, curr_max;
			
			if(arr[i] <= arr[i + 1]) {
				curr_min = arr[i];
				curr_max = arr[i + 1];
			} else {
				curr_min = arr[i + 1];
				curr_max = arr[i];
			}
			
			if(curr_min < prev_min)
				prev_min = curr_min;
			if(curr_max > prev_max)
				prev_max = curr_max;
			
		}
		
		if(arr.length % 2 != 0) {
			if(arr[arr.length - 1] < prev_min)
				prev_min = arr[arr.length - 1];
			else
				prev_max = arr[arr.length - 1];
		}
		
		System.out.println("Minimum : " + prev_min);
		System.out.println("Maximum : " + prev_max);
	}
}

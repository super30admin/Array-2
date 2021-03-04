package Day1;

public class MaxMinUnSortedArray {

	public static void main(String[] args) {
		//Declaring an array of integers
		int[] nums= {1, 5, 7, 3, 56, 2, 6, 8};
		
		//Initializing max an min values
		int min  = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		//looping through the array checking 2 numbers at a time
		for(int i =0; i < nums.length; i=i+2) {
			if(nums[i] < nums[i+1]) {
				if(nums[i] < min) {
					min = nums[i];
				}
				if(max<nums[i+1]) {
					max = nums[i+1];
				}
			}else {
				if(nums[i] > max) {
					max = nums[i];
				}
				if(nums[i+1] < min) {
					min = nums[i+1];
				}
			}
		}
		System.out.println("min: " + min);
		System.out.println("max: " + max);
	}

}

// Time Complexity : O(n/2)
// Space Complexity: O(1)


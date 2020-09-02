/*
 * Given an array of numbers of length N, find both the minimum and maximum. 
 * 
 * Follow up : Can you do it using less than 2 * (N - 2) comparison
 * 
 * Input:
 * nums = [2,5,6,7,8,9,1]
 * 
 * Output:
 * Minimum = 1
 * Maximum = 9
 * 
 * Normal Approach:
 * 	- We compare every number in array with both minimum and maximum
 * 	- return the minimum and maximum values
 * In this approach, there are 2N comparisons, N for minimum and N for maximum
 * But we need less than 2 * (N - 2) comparisons
 * 
 * Pairing numbers approach:
 * 	- First we set the minimum and maximum to initial values by comparing first two numbers in array
 * 	- Then, we traverse through the array from index = 2 till 2nd last element by incrementing the pointer by 2 in each iteration (pairing numbers)
 * 	- While traversing, we:
 * 		1. First, compare the ith and i+1th element
 * 		2. Then, compare the minimum of both with previous minimum element
 * 		3. Then, compare the maximum of both with previous maximum element
 * 	- After exiting the for loop, we check if any extra number is left in array -> in case of odd length of array
 * 		- IF yes, we compare that number with both minimum and maximum -> extra 2 comparisons than even length array
 * This way, we reduce the number of comparisons as we are comparing an element either with maximum or minimum not both 
 * 
 * 
 * 3 -> number of comparisons for each pair
 * n/2 -> total pairs
 * 3*n/2 -> total number of comparisons for n/2 pairs
 * 
 * # of comparisons when N is odd: (3 * n/2) + 2 (2 extra comparisons for the number left in array after exiting for loop)
 * # of comparisons when N is even: (3 * n/2) - 2 (Since, no extra 2 comparisons unlike odd length array as no element is left after exiting for loop)
 * 
 */

/* 
 * Time Complexity: O (N) -> for loop to traverse through array elements
 * 
 * Space Complexity: O (1) -> No extra space used
 * 
 * Did this code successfully run on leetcode: Not on leetcode
 * 
 * Any problem you faced while coding this: Was able to solve with normal approach but pairing of numbers didn't come as intuition to solve this.
 * 
 * 
 * # of comparisons when N is odd -> 1.5N + 2 which is less than 2 * (N - 2)
 * 
 * # of comparisons when N is even -> 1.5N - 2 which is less than 2 * (N - 2)
 * 
 */

package com.s30.edu.array2;

public class MinimumAndMaximum {
	
	public void computeMinMax(int[] nums) {
		
		// Base condition
		if(nums == null || nums.length == 0) {
			return; // Do nothing
		}
		
		// Declare and Initialize min and max values
		int min = 0;
		int max = 0;
		
		// Check if length of array is 1, then same number will be min and max both
		if(nums.length == 1) {
			min = nums[0];
			max = nums[0];
			System.out.println("Minimum number is: " + min + "\n" + "Maximum number is: " + max);
			return;
		}
		
		// Else, in normal case, we go by forming pairs to reduce number of comparisons
		// First, check for 1st two numbers in array and set min and max values
		if(nums[0] < nums[1]) {
			min = nums[0];
			max = nums[1];
		}else {
			min = nums[1];
			max = nums[0];
		}
		
		// Now, we have our min and max, start forming pairs from 2nd index in array. 
		// Traverse from i = 2 to i <= nums.length - 2 (2nd last element) and keep incrementing the pointer by 2in each iteration
		
		for(int i = 2; i <= nums.length - 2; i += 2) {
			// 1. Compare both numbers
			// 2. Compare min of both with previous min
			// 3. Compare max of both with previous max
			
			// 1.
			if(nums[i] < nums[i+1]) {
				// 2.
				min = Math.min(min, nums[i]);
				// 3. 
				max = Math.max(max, nums[i+1]);
			}else {
				// 2. 
				min = Math.min(min, nums[i+1]);
				// 3. 
				max = Math.max(max, nums[i]);
			}
			
		}
		
		// After exiting the for loop, check if there is any extra number left in array
		// Yes -> in case of odd length
		// No -> in case of even length
		
		// Odd length of array?
		if(nums.length % 2 == 1) {
			// If yes, then compare the last number in array with both previous min and max
			min = Math.min(min, nums[nums.length-1]);
			max = Math.max(max, nums[nums.length-1]);
		}
		
		System.out.println("Minimum number is: " + min + "\n" + "Maximum number is: " + max);
		
	}
	
	// main method
	public static void main(String[] args) {
		MinimumAndMaximum minMax = new MinimumAndMaximum();
		int[] array = {2,5,6,7,8,9,1}; // odd length
		minMax.computeMinMax(array);
		
	}

}

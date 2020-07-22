// Time Complexity : O(n) 
// Space Complexity: O(1)

import java.util.Arrays;
public class Max_and_Min {
	/***************************************linear Approach****************************/
	/* Iterate through the array and compare twice to each element to get min and max. 
	 * This leads to 2(n-1) comparisons.*/
	public static int[] findMinMax(int[] nums) {
		if(nums == null || nums.length == 0)
			return new int[0];
		
		int min = nums[0];
		int max = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			if(nums[i] > max)
				max = nums[i];
			if(nums[i] < min)
				min = nums[i];
		}
		int[] minMax = {min, max};
		return minMax;
	}
	
	/************************************Compare in pairs*********************************/
/* If n is odd then initialize min and max as first element.
 * If n is even then initialize min and max as minimum and maximum of the first two elements respectively.
 * For rest of the elements, pick them in pairs and compare their min and max
 * return max and min.*/
	public static int[] findMinMax(int[] nums) {
		int min, max, i;
		int n = nums.length;
		
		//If array has even number of elements then initialize the first two elements as minimum and max
		if(n % 2 == 0) {
			if(nums[0] > nums[1]) {
				max = nums[0];
				min = nums[1];
			}
			else {
				max = nums[1];
				min = nums[0];
			}
			i = 2; //set the starting index for loop
		}
		
		//If array has odd number of elements then initialize the first element as min and max
		else {
			min = nums[0];
			max = nums[0];
			i=1;	//set the starting index for loop
		}
		
		while(i < n-1) {		// pick numbers in pair and compare the pairs with max and min	
			if(nums[i] > nums[i+1]) {
				if(nums[i] > max)
					max = nums[i];
				
				if(nums[i+1] < min)
					min = nums[i+1];
			}
			else {
				if(nums[i+1] > max)
					max = nums[i+1];
				if(nums[i] < min)
					min = nums[i];
			}
			i+= 2;	//Increment the index by 2 as two elements are processed in loop 	
		}
		
		int[] minMax = {min, max};
		return minMax;
	}
	

	public static void main(String[] args) {
		int nums[] = {1000, 11, 445, 1, 330, 5000};
		System.out.println(Arrays.toString(findMinMax(nums)));
	}
}

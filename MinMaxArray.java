
/*
 * Given an array of numbers of length N, find both the minimum and maximum. 
 * Follow up : Can you do it using less than 2 * (N - 2) comparison
 * 
 * 
 * Brute force Approach
	 * Use a for loop for min and max integers and run comparisons in a single for loop
		 Time Complexity : O(n)
		 Space Complexity :O(1)
 * 
 * 
 * */

import java.util.*;
public class MinMaxArray {
	
public static List<Integer> findDisappearedNumbers(int[] nums) {
        
        ArrayList<Integer> result = new  ArrayList<Integer>();
        
        int min = Integer.MAX_VALUE;
        int max = 0;
        
        for(int i = 0; i < nums.length; i++) {
        	if(max < nums[i]) {
        		max = nums[i];
        	}
        	if (min > nums[i]) {
        	min = nums[i];
        	}
        	
        }
        result.add(min);
        result.add(max);
        return result;
}
	
	
	public static void main(String[] args) {
		
		int [] nums = {81,7,6,9,14,22,50};
		
		System.out.println("result : " + findDisappearedNumbers(nums));
	}
}

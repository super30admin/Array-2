/*
 * #448. Find All Numbers Disappeared in an Array
 * 
 * Given an array of integers where 1 <= a[i] <= n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

 */


/*
 * Time Complexity: O (N) + O (N) -> O (2N) -> O (N)  --> Two for loops
 * 
 * Space Complexity: O (1) -> Manipulating the input array and returning the same list as output which we created, so no extra space
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: Not really
 * 
 */

package com.s30.edu.array2;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
		/*
	    * This approach will work only for positive numbers in input array
	    */
	    
	    public List<Integer> findDisappearedNumbers(int[] nums) {
	        // Base condition
	        // If nums is null or length of nums array is zero, return empty ArrayList
	        if(nums == null || nums.length == 0){
	            return new ArrayList<>();
	        }
	        
	        // Create a new ArrayList to store and return the disappeared numbers in array
	        List<Integer> output = new ArrayList<>();
	        
	        /* Traverse through the input array
	        *  For each number in the array while iterating, we will get the index ->  abs(number) - 1
	        *  We will take absolute of number while getting index because we are negating the numbers in array at index calculated like above. 
	        *  So if number is already negated, we will have to take absolute value of it
	        *  Then, check if number at calculated index is positive,
	        *  If yes, then negate it
	        *  Else, do nothing
	        *
	        */
	        for(int num : nums){
	            int index = Math.abs(num) - 1;
	            if(nums[index] > 0){
	                nums[index] *= -1;
	            }
	        }
	        
	        /* After negation, traverse the array one more time to check the positive numbers in array
	        *  positive numbers in array means the disappeared numbers
	        *  If number at index 'i' is positive, then add (i+1) -> disappeared number in output list and return it after exiting for loop*/
	        for(int i = 0; i < nums.length; i++){
	            if(nums[i] > 0){
	                output.add(i + 1);
	            }
	        }
	        
	        return output;
	        
	    }
	    
}

// Time Complexity :less than 2(N/2-1) - 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :N/A
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.*;
import java.io.*;

public class Problem2 {
	public static void main(String[] args) {
		int[] nums= {10000,11,445,10,330,3000};
		//Assign the max & min variable value of array's first element 
		int max= nums[0];
		int min= nums[0];
		//The odd variable takes care of odd length of an array
		boolean odd= true;
		int n= nums.length;
		//Set the odd flag to false, if the array length is even
		if(n%2 == 0) odd =false;
		//Iterate the array comparing the array elements in pairs
		for(int i=0; i< n; i=i+2) {
			if(odd == true && i == n-1) {
				max= Math.max(max, nums[i]);
				min= Math.min(min, nums[i]);
			}
			else if(nums[i] > nums[i+1]) {
				max= Math.max(max, nums[i]);
				min= Math.min(min, nums[i+1]);
			}else {
				max= Math.max(max, nums[i+1]);
				min= Math.min(min, nums[i]);
			}
		}
		System.out.println("Maximum: "+ max);
		System.out.println("Minimum: "+ min);
	}

}

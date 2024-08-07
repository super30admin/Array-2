// Time Complexity : O(n) n:length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :No
// Approach: Make the first element as max and min, and check (max,min) in pairs so that we can reduce number of comparisons

import java.util.Arrays;

public class FindMinMaxInArray {
	public int[] findMinMax(int[] nums) {
		int min = nums[0];
		int max = nums[0];
		for(int i=1;i<nums.length;i=i+2) {
			if(i!=nums.length-1) {
				if(nums[i]<nums[i+1]) {
					min = Math.min(min,nums[i]);
					max = Math.max(max,nums[i+1]);
				}else {
					min = Math.min(min,nums[i+1]);
					max = Math.max(max,nums[i]);
				}
			} else {
				min = Math.min(min,nums[i]);
				max = Math.max(max,nums[i]);
			}
		}
		return new int[] {max,min};
	}
	
	public static void main(String[] args) {
		int [] nums = {100, 2, 5, 1, 6, 7};
		FindMinMaxInArray findMinMaxInArray = new FindMinMaxInArray();
		System.out.print(Arrays.toString(findMinMaxInArray.findMinMax(nums)));
	}

}

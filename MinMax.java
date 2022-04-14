// Time Complexity : O(1.5n) = O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution{
	public int[] minMax(int[]nums){
		int min = Integer.MIN_VALUE;
		int max = Inetger.MAX_VALUE;
		for(int i =0;i<nums.length-1;i=i+2){
			if(nums[i]>nums[i+1]{
				max = Math.max(max,nums[i]);
				min = Math.min(min,nums[i+1]);
			}
			else{
				max = Math.max(max,nums[i+1]);
				min = Math.min(min,nums[i]);
			}
		}
		max = Math.max(max,nums[nums.length-1]);
		min = Math.min(min,nums[nums.length-1]);
		return new int[]{max,min};
	}
}
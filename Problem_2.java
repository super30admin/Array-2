// Time Complexity : O(n/2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : --
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

//Min and Max
class Solution{
	public int[] minMax(int[] nums){
		if(nums == null || nums.length == 0) return (-1,-1);
		int n = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int j = 0;
		if(n % 2 != 0){
			min = nums[j];
			max = nums[j];
			j++;
		}
		for(int i = j; i < n; i+2){
			if(nums[i] < nums[i+1]){
				min = Math.min(min, nums[i]);
				max = Math.max(max, nums[i + 1]);
			}
			else{
				min = Math.min(min, nums[i + 1]);
				max = Math.max(max, nums[i]);
			}
		}
		return (min,max);
	}
}
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class Problem_2 {
	
	public int[] getMinMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if(i  == nums.length - 1) {
				max = Math.max(max, nums[i]);
				min = Math.min(min, nums[i]);
			}
			else if(nums[i] > nums[i+1]) {
				max = Math.max(max, nums[i]);
				min = Math.min(min, nums[i+1]);
			}else {
				max = Math.max(max, nums[i+1]);
				min = Math.min(min, nums[i]);
			}
			i++;
		}
		return new int[] {min, max};
	}
}

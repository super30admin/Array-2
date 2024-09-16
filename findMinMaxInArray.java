// Time Complexity : O(n) where n is the length of the array 
// Space Complexity : O(1) 
// Any problem you faced while coding this : No
// Approach : Iterate thru the array, taking numbers in pairs to reduce the number of comparisons needed.

// Your code here along with comments explaining your approach

class findMinMaxInArray {
	public static int[] findMinMax(int[] nums) {
		if (nums.length == 0) return new int[] {-1,-1};
		if (nums.length == 1) return new int[] {nums[0], nums[0]};
		int min = nums[0], max = nums[0];
		for (int i = 1; i < nums.length; i += 2) {
			if (i == nums.length - 1) {
				min = Math.min(min, nums[i]);
				max = Math.max(max, nums[i]);
			} 
			else {
				int lower = Math.min(nums[i], nums[i+1]);
				min = Math.min(min, lower);
				int higher = lower == nums[i] ? nums[i+1] : nums[i];
				max = Math.max(max, higher);	
			}
		}
		return new int[] {min, max};
	}
	public static void main(String[] args) {
		int[] nums = {4,7,1,8,9,6,3,5};
		int[] ans = findMinMax(nums);
		for (int i : ans) {
			System.out.println(i);
		}
	}
}
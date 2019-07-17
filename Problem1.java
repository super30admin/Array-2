// Idea: 
// 1. First traverse the array and make the index of particular i to be negative
// 2. Now traverse again, and if the index value is positive then that number was missing.
// Time Complexity: O(n)
// Space Complexity: O(1) excluding the space that output List takes
// Run on Leetcode: Yes

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) { 
			int abs_val = Math.abs(nums[i]); 
			if (nums[abs_val - 1] > 0) {
				nums[abs_val - 1] = -nums[abs_val - 1]; 
            }
		}
    
		for (int i = 0; i < nums.length; i++) { 
			if (nums[i] > 0){
                result.add(i + 1);
            }
		} 
        return result;
        
    }
}
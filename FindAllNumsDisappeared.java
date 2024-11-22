// Time Complexity : O(2n)=>O(n). n is the length of the array
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int indexVal = Math.abs(nums[i]) - 1;=>
			if (nums[indexVal] > 0) {
				if (nums[indexVal] > 0)
					nums[indexVal] = -nums[indexVal];
			}

		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				list.add(i + 1);
			}
		}
		return list;
	}
    
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		 List<Integer> res = new ArrayList<Integer>();
		 for(int i = 0; i < nums.length; i++) {
			  if(nums[Math.abs(nums[i])-1] > 0) {
					nums[Math.abs(nums[i])-1] *= -1;
			  }
		 }
		 for(int i = 0; i < nums.length; i++) {
			  if (nums[i] > 0)
					res.add(i+1);
		 }
		 return res;
	}
}
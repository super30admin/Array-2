// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}
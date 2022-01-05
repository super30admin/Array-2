// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : y
// Any problem you faced while coding this : n
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int idx;
        
        for(int i=0; i<nums.length; i++) {
            idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                ans.add(i+1);
            } else {
                nums[i] *= -1;
            }
        }
        
        return ans;
    }
}

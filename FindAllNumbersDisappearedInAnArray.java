// Time Complexity : O(N) where N is the length of the nums array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I initially missed checking if the number is already negative then don't multiply it again by -1.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int m = Math.abs(nums[i]) - 1;
            nums[m] = nums[m] < 0 ? nums[m] : -1 * nums[m];
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0 )
                res.add(i+1);
        }
        return res;
    }
}

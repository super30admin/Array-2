// Time Complexity : O(n), where n is the length of the input array nums
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0){
                nums[val] *= -1;
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                result.add(i+1);
            } else {
                nums[i] *= -1;
            }
        }
        return result;
    }
}
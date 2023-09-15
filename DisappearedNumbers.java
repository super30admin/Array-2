// Time Complexity :
//O(n)
// Space Complexity :
//O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//taking number - 1 in nums array as index and changing value * -1. Finally returning positive values from list
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length ==0) {
            return new ArrayList<>();

        }
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                result.add(i+1);

            }
            else {
                nums[i] = nums[i] * -1;
            }

        }
        return result;
    }
}
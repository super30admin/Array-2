// Time Complexity : O(n), n-> length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums.length == 0 || nums == null)
            return result;
        for(int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]) - 1;
            if(nums[x] >= 0)
                nums[x] *= -1;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                result.add(i + 1);
        }
        return result;
    }
}
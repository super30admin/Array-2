// Time Complexity : O(n) --> where n is length of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (448): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {    
        List<Integer> result =  new ArrayList<>();
        if (nums == null || nums.length == 0) return new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) nums[idx] *= -1;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i + 1);
        }
        return result;
    }
}
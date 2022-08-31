// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        
        // null check
        if (nums == null || nums.length == 0) return res;
        
        /* TEMPORARY STAGE CHANGE PATTERN */
        // mark all the indexes for which value is encountered
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i])-1;
            if (nums[idx] > 0)      // if not already visited
                nums[idx] *= -1;   // mark visited
        }
        
        // unmark visited elements & add the unvisited elements in the result
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)        
                nums[i] *= -1;
            else
                res.add(i+1);
        }
        
        return res;
    }
}

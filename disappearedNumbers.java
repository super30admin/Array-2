// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        int n = nums.length;

        // Itterate over all the elements of the input list and jump to the index of value-1, and mark it as -ve if its not already
        for(int i=0; i<n; i++) {
            int curr = nums[i];
            if (nums[Math.abs(curr)-1] > 0) {
                nums[Math.abs(curr)-1] *= -1;
            }
        }

        // In the second iteration check if the value is positive and store (index+1) in the result array.
        for(int i=0; i<n; i++) {
            if (nums[i]>0) {
                ans.add(i+1);
            }
        }

        return ans;
    }
}
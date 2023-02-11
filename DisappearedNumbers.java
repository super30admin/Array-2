// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//changed the number present to negative to indicate its presence

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]) - 1;
            if (nums[num] > 0)
                nums[num] *= -1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                ans.add(i + 1);
        return ans;
    }
}
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Solution:
// TC: O(N)
// SC: O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        // make value negative at index = current number - 1
        // after traversal all the numbers will be marked as negative which are already present
        for(int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);

            if(nums[num - 1] > 0)
                nums[num - 1] = -1 * nums[num - 1];
        }

        // we need to find positive number which means it's not present in array
        // add that number using the index in result
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
}



// -4 -3 -2 -7 8 2 -3 -1
//  0  1  2  3 4 5  6  7



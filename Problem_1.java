// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* To achieve TC of O(n) and SC of O(1), we try to use inplace values of array to find missing numbers. We traverse the array and mark elements
   at index calculated as negative. In the end, the numbers which are not negative are the ones which are missing at the index. So we add (index + 1) to the
   list and return it.
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<Integer>();

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; ++i) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0)
                nums[idx] *= -1;
        }

        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] > 0)
                result.add(i + 1);
        }
        return result;
    }
}
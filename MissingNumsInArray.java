// Time Complexity : O(N)
// Space Complexity : O(N) iterating through the hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        // base case
        if (nums == null || nums.length == 0) return new ArrayList<Integer>();

        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = nums.length;

        HashSet<Integer> mySet = new HashSet<Integer>();

        for (int i=0; i< n; i++) {
            mySet.add(nums[i]);
        }

        for (int i=1; i <= n; i++) {
            if (!mySet.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
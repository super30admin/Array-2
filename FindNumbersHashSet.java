// Time Complexity : O(n) where 'n' is the length of the nums.
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
// Any problem you faced while coding this : No

// 448: Find all Numbers Disappeared in an Array


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}

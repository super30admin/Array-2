// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        int i = 0;
        for (int num = 1; num <= n; num++) {
            if (i >= nums.length || nums[i] > num) {
                result.add(num);
            }
            while (i < nums.length && nums[i] == num) {
                i++;
            }
        }
        return result;
    }
}

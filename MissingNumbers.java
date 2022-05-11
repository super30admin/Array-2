// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int currIndexToMark = 0;
        // temporary state change pattern - where we currently mutuate the position of the taken number at every iteration will be marked as negative, we do another iteration post this, to find the actual positions, where are of positive numbers
        for(int i=0;i<nums.length;i++) {
            currIndexToMark = Math.abs(nums[i])-1;
            if(nums[currIndexToMark] >0) {
                nums[currIndexToMark] *= -1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }
}
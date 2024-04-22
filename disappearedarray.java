// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i <= n - 1; i++){
            int absVal = Math.abs(nums[i]); //Cal the absolute value to be able to calc the index
            if(nums[absVal - 1] > 0){
                nums[absVal - 1] *= -1; //If the index is found as an elem in the array, multiply it by -1
            }
        }

        for(int i = 0; i <= n - 1; i++){
            if(nums[i] > 0){
                result.add(i + 1); //Add all the positive number and that calc the elem that is not present
            }
        }
        return result;
    }
}
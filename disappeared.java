// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1; // get absolute value and then get index
            if(   nums[index] > 0  ){ // if positive
                nums[index] = nums[index] * - 1; // make it negative
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){ // changing back to it original value or add to the result array
            if(nums[i] > 0){
                result.add(i + 1);
            }else{
                nums[i] = nums[i] * - 1;
            }
        }

        return result;
    }
}
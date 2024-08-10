// Time Complexity : O(n)
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english: I used the same logic Jaspinder explained. 

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i<nums.length; i++){
            int curNum = Math.abs(nums[i]);
            int idx = curNum - 1;
            if(nums[idx] > 0){
                nums[idx] = nums[idx] * -1; 
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        } 
        return result;
    }
}
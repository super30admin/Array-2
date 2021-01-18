// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)
            return result;
        for(int i = 0;i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                //make it -ve
                nums[index] *= -1;
            }
        }
        //Looking for all the +ve numbers if +ve add to result
        for(int i = 0; i< nums.length; i++){
            if(nums[i] > 0){
                result.add(i + 1);
            }
        }
        return result;
    }
}
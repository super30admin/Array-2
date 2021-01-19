
// Time Complexity : O(n) where n is number of elements in Array.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList();
        List<Integer> result = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;   
            if(nums[idx] > 0){
                nums[idx] *= -1; 
            }
           
        }
         for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i + 1);
            }
            else{
                nums[i] *= -1;
            }
        }
        return result;
    }
}

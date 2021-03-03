// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        
        //edge case
        if(nums.length == 0 || nums == null){
            return arr;
        }
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] > 0){
                nums[idx] *= -1;
            }
        }
        for(int i = 0;i < nums.length; i++){
            if(nums[i] > 0){
                arr.add(i + 1);
            }
        }
        return arr;
        
    }
}
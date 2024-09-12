// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Syntax Errors

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length >= 1){
            
          for(int i=0; i<nums.length;i++){
              int index = Math.abs(nums[i]) - 1;
             
              if(nums[index] > 0){
                  nums[index] = 0-nums[index];
              }
          }
            
        for(int i=0; i<nums.length;i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        }
        return list;
    }
}
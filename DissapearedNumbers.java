// Time Complexity : O(N)
// Space Complexity : O(1) - No auxillary space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        for(int i = 0;i< nums.length;i++){
            int temp = nums[i];
            if(temp < 0){
               temp *= -1;
           }
           if(temp <= nums.length) {
              if(nums[temp - 1] > 0){
               nums[temp-1] *= -1;
              } 
           }
        }
        List<Integer> res = new ArrayList<Integer> ();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i + 1);
            }
        }
        return res;
    }
}

// Time complexity 0(n)
// space complexity 0(n)
// Code was successfully executed in leetcode.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result  =  new ArrayList<>();
          //edge case
        if(nums == null || nums.length == 0) return result;
         
        for(int i=0;i<nums.length;i++){
            
            int id = Math.abs(nums[i])-1;
            if(nums[id] > 0) nums[id] *= -1;
        }
    
         
        for(int i=0;i<nums.length;i++){
           if(nums[i]>0) result.add(i+1);
        }
        
      return result ;
    }
}
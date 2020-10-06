/**
Algorithm :
[4,3,2,7,8,2,3,1]
 0,1,2,3,4,5,6,7
 
[-4,-3,-2,-7,2,3,-3,-1]

Take abs as if you repeat twice, it should still remain negative.

TC : O(n)
SC : O(1) in place

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        ArrayList<Integer> output = new ArrayList<>();
        
        //Base Case
        if(nums== null || nums.length ==0)
            return output;
        
        for(int i=0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0){
                nums[idx] = -nums[idx];
            }
        }
        
        for(int i=0; i < nums.length; i++){
            if(nums[i] > 0)
                output.add(i+1);
        }
        
        return output;
    }
}
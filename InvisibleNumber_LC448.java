
 // Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        for(int i =0; i<nums.length;i++){
        // find the index of the ith element in array    
       int index = Math.abs(nums[i])-1;
       //if the value is positive then mark it negative
            if(nums[index]>0){
               nums[index] *=-1;   
            }
        }
    List<Integer> result = new ArrayList<>();
        
        //check if there are positive element , yes? then add index +1 to result
        for(int i = 0; i<nums.length;i++){
        if(nums[i]>0){
            result.add(i+1);
        }
    }
        return result;
    }
}
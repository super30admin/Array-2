// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//Iterate over the array and consider the index that is if we encounter the value 4 in the index 0 then negate the value of indices 4 with 
//which we can conclude that we have visited that index and that value exist in the array later Iterate again and check which value is not
//negated then that index+1  is absent in the array.

import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums==null ||nums.length==0)return result;
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = nums[index]*(-1);
            }
            
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }return result;
    }
}
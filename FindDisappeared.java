import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int l = nums.length;
        if(l<0) return null;
        List<Integer> result = new ArrayList<>();;
        for(int i=0; i<l; i++){
            int temp=nums[i];
            if(temp<0){
                temp *= -1; //if the element is already negative, make it positive
            }       
            if(temp<=l){
                if(nums[temp-1]>0){ //check if the exsisting number is not negative, if negative do not do anything
                nums[temp-1]*=-1; //make with temp's place element negative
                }

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
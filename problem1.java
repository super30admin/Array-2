// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result= new ArrayList<>();
        int idx;
        //first pass to make the existing numbers nums[index] negative
        for(int i=0; i<nums.length; i++){
            //find the index which matched the current nums[i]
            idx=Math.abs(nums[i])-1;
            if(nums[idx]>0){
                //if the number at the index found above is +ve, make it negative
                nums[idx] *= -1;
            }
        }
        //second pass to check for positive numbers
        for(int i=0;i<nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}
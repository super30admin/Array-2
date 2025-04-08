// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach:
// Iterate through array and mark visited indices by making the value negative at corresponding index. 
// Collect indices with positive values, which are the missing ones. 
// Change the array to original form by changing the negative numbers to positive.

import java.util.*;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            int idx=Math.abs(nums[i])-1;
            if(nums[idx]>0){
                nums[idx]*=-1;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
            else{
                nums[i]*=-1;
            }
        }
        return res;
    }
}
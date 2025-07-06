// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>  results =new ArrayList<Integer>();
        for( int i=0;i<nums.length;i++){
           int index =  Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
              nums[index] = -nums[index];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
              results.add(i+1);  
            }
        }

        return results;
    }
}
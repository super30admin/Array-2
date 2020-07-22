// Time Complexity :O(n)
//      n: number of elements in array
// Space Complexity :O(1)
//      Not counting result
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

import java.util.List;
import java.util.ArrayList;

class Problem1 {

    /** find missing number from the sequence */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        // result
        List<Integer> result = new ArrayList<>();
        
        // edge case
        if(nums==null || nums.length==0)
            return result;
        
        // iterate 
        for(int i=0;i<nums.length;i++){
            
            // get absolute value
            int index =  nums[i];
            index = (index > 0) ? index : Math.abs(index);

            // make element at index negative
            if (nums[index-1] > 0)
                nums[index-1] *= -1;
        }
        
        // missing value are the indexes which are positive
        for(int i=0;i<nums.length;i++){
            if(nums[i] >0)
                result.add(i+1);
        }
        
        //return result
        return result; 
        
    }
}
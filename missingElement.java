

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;
public class missingElement {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        if(nums==null || nums.length==0)
            return result;
        
        for(int i=0;i<nums.length;i++){
            
            int idx=Math.abs(nums[i])-1;
            
            if(nums[idx]>0){
                nums[idx]*=-1;
            }
        }
        
         for(int i=0;i<nums.length;i++){
             
             if(nums[i]>0){
                 result.add(i+1);
             }
         }
        return result;
    }
    
}

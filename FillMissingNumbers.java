import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class FillMissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList();
        for(int i=0;i<nums.length;i++) {
            //indexing from 0
            int newIndex=Math.abs(nums[i])-1;
            //mark the index visited
            if (nums[newIndex] > 0) nums[newIndex] *= -1;
        }
        for(int i=1;i<=nums.length;i++){
             if(nums[i-1]>0) result.add(i);
         } 
        return result;
    }
}

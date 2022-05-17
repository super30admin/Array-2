// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :  NO

// Iterating through the array, I'll make element as negative at out current element index;
//Then In second iteration, I'll add indexes at which elements are greater than 0
import java.util.LinkedList;
import java.util.List;

public class DisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res= new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            int ele = nums[i];
            if(ele <0) ele *= -1;
            if(nums[ele-1] > 0)
                nums[ele-1] *= -1;
        }
        for(int i =0; i < nums.length; i++){
            if(nums[i] > 0)
                res.add(i + 1);
        }
        
        return res;
    }
    
}
import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Find disappearing numbers in an array
public class Problem1 {
    //time:O(n)
    //space: O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        if(list == null) return list;
        for(int i=0; i<nums.length;i++){
            int index = Math.abs(nums[i]);
            if(nums[index-1]>0)
                nums[index-1] = -1 * nums[index-1];
        }
        for(int i=0; i<nums.length;i++){
            if(nums[i]>0)
                list.add(i+1);
        }
        return list; 
    }
}
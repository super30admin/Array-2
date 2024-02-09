import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Iterate through each index and get the value, then get to the index equals value-1
// mark it as -ve value to indicate we have identiefied the occurance of element
// Value-1 is taken as index since the array elements are starting from 1 to N
// Once the entire array is iterated the array indeces with positive values when incremented by 1 gives the missing numbers


public class Problem1_FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int temp = Math.abs(nums[i])-1;
            if(nums[temp]>0)
                nums[temp]*=-1;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0)
                res.add(i+1);
        }
        return res;
    }
}

import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(M) where M is the number elements in array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Run through the array, and whereever you find a number,
// go to number-1 index and mark it as -num[idx].. finally where ever +ve nums are found, those idx+1 nums are missing.
public class NumsDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length==0 || nums==null) return new ArrayList<>();
        List<Integer> result= new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]>0)
                nums[Math.abs(nums[i])-1]*=-1;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                result.add(i+1);
        }

        return result;
    }
}

import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0){
            return new ArrayList<>();
        }
        ArrayList result= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int new_index= Math.abs(nums[i]) -1;
            if(nums[new_index]>0){
                nums[new_index]= nums[new_index] *-1;
            }
        }
        for(int i=0; i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}
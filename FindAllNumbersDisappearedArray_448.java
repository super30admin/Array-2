import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)  => n = number of elements in nums
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        
        List<Integer> result= new ArrayList<>();
        
        //encoding to save space 
        for(int x:nums){
            int element = Math.abs(x) -1;
            
            if(nums[element] > 0){
                nums[element] = nums[element] * -1;
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
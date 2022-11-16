// Time Complexity : O(n)
// Space Complexity :O(1) 
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList<>();
        List<Integer> ans=new ArrayList<>();    
        for(int i=0;i<nums.length;i++){
            int index= Math.abs(nums[i])-1;
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
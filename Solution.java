// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> result=new ArrayList<>();
        
        if(nums == null || nums.length==0)return result;
        for(int i=0; i< nums.length;i++){
            int inx=Math.abs(nums[i])-1;
            if(nums[inx]>0){
                nums[inx] *=-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums[i] *=-1;
            }
            else{
                result.add(i+1);
            }
        }
        return result;
    }
}
import java.util.ArrayList;
import java.util.List;

/**
## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
 
Time Complexity :   O (N) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (448. Find All Numbers Disappeared in an Array)
Any problem you faced while coding this :       No
 */

 class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0){
            return res;
        }
        
        int len = nums.length;
        
        for(int i=0; i<len; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0){
                nums[idx] *= -1;    // make negative i.e present
            }
        }
        
        for(int i=0; i<len; i++){
            if(nums[i] < 0){
                nums[i] *= -1;    // make positive again
            }else{
                res.add(i+1);     // missing element
            }
        }
        return res;
    }
    
    public static void main(String args[]) 
    { 
        FindDisappearedNumbers obj = new FindDisappearedNumbers();
        int nums[] = {4,3,2,7,8,2,3,1};
        List<Integer> res = obj.findDisappearedNumbers(nums);

        // print Missing Element
        for(int num: res){
            System.out.print(num +" ");
        }
    }
}
//Problem 31: Find missing number inclusive of 1 to n 
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// This is a state change pattern, while iterating over array, just make element negative which are at abs(current element)-1
// Once above step is completed juust iterate over the array again and in result add (index+1) of those elements which are positive.    
import java.util.*;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> res = new ArrayList<>();
        
        if(nums==null ||nums.length==0){
            return res;
        }
        //TC: O(2N)=> O(N), SC: O(1)
        //This is a state change pattern
        //Making elements -ve at num[i]-index
        for(int i=0;i<nums.length;i++){
            
            int idx = Math.abs(nums[i])-1;
            
            if(nums[idx]>0){
                nums[idx] *= -1;
            }
        }
        
        //Now look which numbers are +ve and add(index+1) because they arec going to be missing numbers
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);//missing number
            }else{//if interviewer wants the existing array
                nums[i] *= -1;
            }
        }
        
        
        //Brute force
        //TC: O(n), SC:O(n)
        /*Set<Integer> set = new HashSet<>();
        
        
        for(int i=0;i<nums.length;i++){
            
            set.add(nums[i]);
            
        }
        
        for(int i=1;i<=nums.length;i++){
            
            if(!set.contains(i)){
                res.add(i);
            }
        }*/
     
        return res;
    }
}
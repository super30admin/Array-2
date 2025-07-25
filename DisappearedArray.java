// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Approach:
We're given an array where numbers are in the range [1, n].
The goal is to find all numbers in this range that are missing from the array.
To avoid using extra space, we mark the presence of each number by making the value at its corresponding index negative.
For example, for value `4`, we mark index `3` (`4-1`) as negative.
In the second pass, any index that has a positive value means the number `(index + 1)` was missing from the original array.
We also restore the array to its original state.
*/


import java.util.*;


public class DisappearedArray {
    public List<Integer> solve(int[] nums){
         if(nums==null || nums.length==0){
            return new ArrayList<>();
         }
         int n = nums.length;
         List<Integer> res = new ArrayList<>();
         for(int i = 0; i < n; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0){
                nums[idx] = nums[idx] * -1;
            }
         }

         for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
            else{
                nums[i] = nums[i] * -1;
            }
         }
         return res;
    }

    public static void main(String[]args){
        DisappearedArray ob = new DisappearedArray();
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums2 = {1, 1};
        System.out.println("Numbers disapperead in the array are: "+ob.solve(nums1));
        System.out.println("Numbers disappeared in the array are: "+ob.solve(nums2));

    }
    
}

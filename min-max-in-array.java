// Que:- Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class Solution {
    public static void main(String args[]) {
        //sample input
        int[] nums = new int[]{3,-4,1,0,-3,2,-1,5};
        int n = nums.length;
        int max =0;
        int min =0;
        //comparing the numbers in pairs and finding the max and min
        for(int i = 0 ; i< n; i++){
            if(nums[i]> nums[i+1]){
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            }else{
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);
            }
            i++;
        }
        //printing the max and min as a result
        System.out.println(max +" "+ min);
    }
}


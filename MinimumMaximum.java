/**
## Problem2
Given an array of numbers of length N, find both the minimum and maximum. 
Follow up : Can you do it using less than 2 * (N - 2) comparison
 
Time Complexity :   O (N)    - 1.5n Comparisons
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes ()
Any problem you faced while coding this :       No
 */

 class MinimumMaximum {
    public void minimumMaximum(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for( int i = 0; i< n - 1; i++){
            if(nums[i] > nums[i+1]){
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            }else{
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);
            }
        }
        System.out.println("Max: "+ max);
        System.out.println("Min: "+ min);
    }
    
    public static void main(String args[]) 
    { 
        MinimumMaximum obj = new MinimumMaximum();
        int[] nums = new int[]{2,3, 8, 5,9,1, 4};
        obj.minimumMaximum(nums);
    }
}
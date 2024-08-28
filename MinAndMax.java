// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach
// Reduce the number of comparisions by thinking in pairs. Generally we do 2 comparisions for each element -> max & min. While doing in pairs we do 3 comparisions for 2 elements.

public class MinAndMax {
    void findMinMax(int[] nums){
        int max= Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int n= nums.length;

        for(int i=1;i<n;i=i+2){
            if(nums[i-1]<nums[i]){
                max = Math.min(nums[i], max);
                min = Math.min(nums[i-1], min);
            } else{
                max = Math.min(nums[i-1], max);
                min = Math.min(nums[i], min);
            }
        }

        if(n%2!=0){
            max = Math.min(nums[n-1], max);
            min = Math.min(nums[n-1], min);
        }
    }
}

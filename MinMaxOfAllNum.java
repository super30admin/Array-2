import java.util.*;

class Solution{
    // Time Complexity : O(length of nums)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
1. take 2 nums at a time 
2. compare  n[i],n[i+1]    local min, gloabl min    local max, global max
*/

    public  static int[] findMinMax(int[] nums){
        int[] minMax = new int[2];

        if(nums == null || nums.length == 0) return minMax;

        minMax[0] = nums[0];
        minMax[1] = nums[1];

        int bound = nums.length;

        if(nums.length % 2 == 1){
            bound = bound-1;     
        }

        int min = 0; int max = 0;
        for(int i =0;i<bound;i =i+2){
            if(nums[i]<nums[i+1]){
                min = nums[i];
                max = nums[i+1];               
            }
            else{
                min = nums[i+1];
                max = nums[i];
            }
            if(min<minMax[0]){
                minMax[0] = min;
            }
            if(max>minMax[1]){
                minMax[1] = max;
            }
        }

        if(bound != nums.length){
            if(nums[bound] < minMax[0] ){
                minMax[0]  = nums[bound];
            }
            if(nums[bound] > minMax[1] ){
                minMax[1]  = nums[bound];
            }
        }
        return minMax;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i =0; i<n;i++){
            nums[i] = sc.nextInt();
        }
        int[] result = new int[2];
        findMinMax(nums);
        result = findMinMax(nums);
        System.out.println(result[0] + " "+result[1]);
    }
}
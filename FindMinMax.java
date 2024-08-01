// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

import java.util.Arrays;

class FindMinMax {
    public int[] findMinMax(int[] nums) {
         int[] result = new int[2];
            if(nums.length==1){
                 result[0] = nums[0];
                 result[1] = nums[1];
                 return result;
            }
            int min = nums[0];
            int max = nums[1];
            if(nums[1]<nums[0]){
                min = nums[1];
                max = nums[0];
            } 
            int i;
            for(i=2;i+1<nums.length;i++){
                if(nums[i]<nums[i+1]){
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i+1]);
                } else{
                    min = Math.min(min, nums[i+1]);
                    max = Math.max(max, nums[i]);
                }
            }
            if(i==nums.length-1){
                 min = Math.min(min, nums[i]);
                max= Math.max(max, nums[i]);
            }
            result[0] = min;
            result[1] = max;
            return result;
    }


       public static void main(String[] args) {
        FindMinMax obj = new FindMinMax();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(Arrays.toString(obj.findMinMax(nums)));
        }

}
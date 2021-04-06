// Time Complexity : O(N) with O(3N/2) comparisons
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class HelloWorld{
     public static void main(String []args){
        int[] nums = new int[]{1,1,1,1,9};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int i = 0;
        if(nums.length % 2 != 0){
            max = nums[0];
            min = nums[0];
            i = 1;
        }
        for(; i < nums.length ; i+=2){
            if(nums[i] < nums[i+1]){
                min = Math.min(min,nums[i]);
                max = Math.max(max,nums[i+1]);
            }else{
                min = Math.min(min,nums[i+1]);
                max = Math.max(max,nums[i]);
            }
        }
        System.out.println(min);
        System.out.println(max);
     }
}


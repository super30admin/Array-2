// Time Complexity :O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not on leetcode
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.Arrays;

public class MinMax {

    public static void main(String args[]){
        int[] nums = {-14,5,234,46,34,6,45,34,1000};
        System.out.println(Arrays.toString(MinAndMax(nums)) );
    }

    static int max =0;
    static int min =0;
    public static int[] MinAndMax(int[] nums){
        int n = nums.length;
        //iterating 2 elements in 1 go to minimise the comparisons
        //so now the total number of comparisons is 3 per 2 elements
        // i.e., Total comparison = 3 * n/2 = 1.5n comparisons which was 2n comparison before
        if(n%2==0){
            forLoop(nums, nums.length);
        }else{
            forLoop(nums, nums.length-1);
            max = Math.max(max,nums[n-1]);
            min = Math.min(min,nums[n-1]);
        }
        return new int[] {min,max};
    }

    public static void forLoop(int[] nums,int index){
        for(int i=0;i<index;i=i+2){
            if(nums[i] >= nums[i+1]){
                max = Math.max(max,nums[i]);
                min = Math.min(min,nums[i+1]);
            }else{ // when nums[i] < nums[i+1]
                max = Math.max(max,nums[i+1]);
                min = Math.min(min,nums[i]);
            }
        }
    }
}

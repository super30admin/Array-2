// Time Complexity : O(1.5*n) = O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Problem2 {
    private static int[] findMinMax(int[] nums){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int i = 0;

        for(i =0; i< nums.length-1; i+=2){
            if(nums[i] > nums[i+1]){
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i+1]);
            }
            else{
                max = Math.max(max, nums[i+1]);
                min = Math.min(min, nums[i]);
            }
        }
        if(nums.length %2 != 0){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        return new int[]{min, max};
    }

    public static void main(String[] args){

        //int[] arr = {2,4,50,7,0,10,100,9,40,8};
        //int [] arr = {2};
        int[] arr = {10, 5, 1};
        int[] result = findMinMax(arr);
        System.out.println("min = "+result[0]+", max = "+ result[1]);
    }
}

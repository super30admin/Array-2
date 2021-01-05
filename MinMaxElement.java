import java.util.Arrays;
/*
// Time Complexity : O(n)
// Space Complexity :
// Did this code successfully run on Leetcode : N/A
// Three line explanation of solution in plain english
Approach 1: is to compare every element with min and max value. This would give more than 2(n-1) comparisions

Optimised solution:
take numbers in pairs and compare with each. then update local min and local max (1 comparison)
then compare local min,max with global min and max (2 comparisons)



// Your code here along with comments explaining your approach
 */
public class MaxMin {
    public static  int[] MaxMin(int [] nums){
        if(nums.length == 0){
            return new int[2];
        }

        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length-1;i++){

            int currMin, currMax;
            if (nums[i] > nums[i+1]){
                currMin = nums[i+1];
                currMax = nums[i];
            }else {
                currMin = nums[i];
                currMax = nums[i+1];
            }

            if (minimum > currMin){
                minimum = currMin;
            }
            if (maximum < currMax){
                maximum = currMax;
            }

        }

        return new int[]{minimum,maximum};
    }

    public static void main(String[] args) {
        int[]array = {5,7,2,4,9,6,10};
        int[]res = MaxMin(array);
        System.out.println(Arrays.toString(res));
    }
}

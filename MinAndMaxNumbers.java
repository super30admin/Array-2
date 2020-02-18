/*
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
*/

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : leetcode playground
// Any problem you faced while coding this :  no


/*
Approach:
=========
1. Assign min and max to arr[0]
2. Update min and max at every index in one pass by comparing with elements until max and min are found 
3. Implies 2(N-2) comparisions
*/
public class Solution {
    
    private static int[] findMinAndMax(int[] arr) {
    	if(arr == null || arr.length == 0) return new int[]{};
        int min = arr[0];
        int max = arr[0];

        for(int i = 1; i < arr.length; i++) {
        	//update max is bigger value found
            if(arr[i] > max) 
                max = arr[i];

            //update min if smaller value found
            if(arr[i] < min)
                min = arr[i];
        }
        return new int[]{min,max};
    }
    public static void main(String[] args) {
        int[] arr = new int[]{12,4,3,2,4,3,3,33,22,2,22,2,22,22,5,56,5,5,5,5,934,4,343,3344,7677,7767,8878,978667,567,77,86};
        int[] result = findMinAndMax(arr);
        System.out.println(result[0]+" "+result[1]);
    }
}
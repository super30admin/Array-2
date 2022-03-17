// Time Complexity : O(N)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public class Solution {
    public static void main(String[] args){
        int[] arr = {4,-6,1,8,6,0,9};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int i = 1;
        while(i <= arr.length - 1){
            //3 Comparisions everytime 
            if(arr[i] < arr[i-1]){
                max = Math.max(max, arr[i-1]);
                min = Math.min(min, arr[i]);
            }else{
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i-1]);
            }
            if(i == arr.length - 1){ // For odd length of array --- Only 2 comparisions
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }
            
            i = i + 2;
        }

        //Total comparisions = 3 * (N/2) which is less than 2*(N-2)


        System.out.println("Max = " + max + "  Min = "  + min );

    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class MaxMinOfArray {
    public static void main(String args[]){
        int[] arr = new int[]{22, 14, 8, 17, 35, 3};
        int n = arr.length;
        int min = arr[0], max = arr[0];

        for(int i = 1; i < n-1 ; i++){
            if(arr[i] < arr[i + 1]){
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i + 1]);
            }
            else{
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i + 1]);
            }
        }

        System.out.println("Max: "+ max + "\nMin: "+ min);
    }
}

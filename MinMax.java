// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
compare elements in pairs
 */

import java.io.*;
import java.util.*;
// Java program of above implementation
public class GFG {

    /* Class Pair is used to return two values from getMinMax() */
    static class Pair {

        int min;
        int max;
    }

    static Pair getMinMax(int arr[], int n) {
        Pair minmax=new Pair();
        int index=0;

        if(n%2==0){
            if(arr[0]>arr[1]){
                minmax.min=arr[1];
                minmax.max=arr[0];
            }
            else {
                minmax.min=arr[0];
                minmax.max=arr[1];
            }
            index=2;
        }
        else {
            minmax.min=arr[0];
            minmax.max=arr[0];
            index=1;
        }

        while(index < n-1){
            if(arr[index]>arr[index+1]){
                if(arr[index]>minmax.max){
                    minmax.max=arr[index];
                }
                if(arr[index+1]<minmax.min){
                    minmax.min=arr[index+1];
                }
            }
            else {
                if(arr[index+1]>minmax.max){
                    minmax.max=arr[index+1];
                }
                if(arr[index]<minmax.min){
                    minmax.min=arr[index];
                }
            }
            index=index+2;
        }
        return minmax;
    }

    /* Driver program to test above function */
    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.printf("Minimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);

    }
}
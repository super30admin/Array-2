// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachclass findMinMax {

import java.util.*;
import java.math.*;
public class Solution{

     public static void main(String []args){
        int[] arr  = {1,4,7,2,5,3,11};
        int[] ans = getMinMax(arr);
        System.out.println("Min "+ ans[0]);
        System.out.println("Max "+ans[1]);
     }
     
     public static int[] getMinMax(int[] arr) {
        int pairs = arr.length/2;
        int leftOver = arr.length - pairs*2;
        int totalMax = 0;
        int totalMin = Integer.MAX_VALUE;
        //Loop all the pairs
        for(int i=0;i<arr.length-1;i+=2)  {
            int min = arr[i] < arr[i+1] ? arr[i]:arr[i+1];
            int max = arr[i] > arr[i+1] ? arr[i]:arr[i+1];
            
            totalMin = Math.min(min, totalMin);
            totalMax = Math.max(max, totalMax);
        }
        //Loop the elements left in case there are odd number of elements
        for(int i=pairs*2; i<arr.length;i++) {
            totalMin = Math.min(arr[i], totalMin);
            totalMax = Math.max(arr[i], totalMax);
        }
        int ans[] = {totalMin, totalMax};
        return ans;
     }
}

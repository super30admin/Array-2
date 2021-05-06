  
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : not on leetcode
// Any problem you faced while coding this : no

import java.lang.Math;
public class MinMax {
    public static void main(String[] args) {
        int []arr = {2,8,7,6,1,11,-8,16};
        
        int min = Math.min(arr[0],arr[1]);
        int max = Math.max(arr[0],arr[1]);
        if(arr.length == 2) return;
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){  //comparing the elements of array
                min = Math.min(min,arr[i+1]);  //assigning the corresponding min and max after comparing.
                max = Math.max(max,arr[i]);
            }else{
                min = Math.min(min,arr[i]);
                max = Math.max(max,arr[i+1]);
            }
        }
        System.out.println("Max "+max+" and Min"+min);
    }
}

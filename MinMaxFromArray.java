// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.Arrays;

public class MinMaxFromArray {
    public static int[] minMax(int[] arr){
        // int min = 999999;
        // int max = -999999;
        int[] result = new int[]{999999,-999999};
        for(int i=0;i<arr.length;i++){
            if(i<arr.length-1 && arr[i]>arr[i+1]){
                result[0] = Math.min(result[0],arr[i+1]);
                result[1] = Math.max(result[1],arr[i]);
            }else if(i<arr.length-1 && arr[i]<arr[i+1]){
                result[0] = Math.min(result[0],arr[i]);
                result[1] = Math.max(result[1],arr[i+1]);
            }else if(i == arr.length-1){
                result[0] = Math.min(result[0],arr[i]);
                result[1] = Math.max(result[1],arr[i]);
            }
        }
        return result;
    }

    public static void main(String args[]){
        int[] arr = {5,5,5,5,5,5,5,5,5};
        int[] result = MinMaxFromArray.minMax(arr);
        System.out.println(Arrays.toString(result));
    }
}

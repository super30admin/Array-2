import java.util.Arrays;
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// - Instead of comparing all the numbers we are just comparing pairs which makes the no. of comparisons as n/2
// - we use min and max variables to store the values

public class MinMaxFinder {
    public static int[] findMinAndMax(int[] arr){
        int n = arr.length;
        int i = 0;
        int max, min ;
        // Handle first pair (or first element if odd length)
        if(n%2 == 0){
            if(arr[0] < arr[1]){
                min = arr[0];
                max = arr[1];
            }
            else{
                min = arr[1];
                max = arr[0];
            }
            i=2;
        }else{
            min = max = arr[0];
            i = 1;
        }

        // Here we process the other pairs
        while(i < n-1){
            if(arr[i] < arr[i+1]){
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i+1]);
            }
            else{
                min = Math.min(min, arr[i+1]);
                max = Math.max(max, arr[i]);
            }
            i = i+2;
        }
        return new int[] {max, min};
    }
    public static void main(String[] args){
        int[] arr = {3,5,4,1,9,8};
        System.out.println(Arrays.toString(findMinAndMax(arr))); // output:[9,1]
    }
}

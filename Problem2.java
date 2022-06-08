// Time Complexity : O(1.5n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not a leetcode problem
// Any problem you faced while coding this : No

//Find max and min of an array using minimum number of comparisons
public class Problem2 {
    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = arr.length;
        int max = arr[0];
        int min = arr[0];

        for(int i=0; i<arr.length; i++){
        if (arr[i] > arr[i+1]) {
            if(max<arr[i]) max = arr[i];
            if(min>arr[i+1]) min = arr[i+1];
        } else {
            if(max<arr[i+1]) max = arr[i+1];
            if(min>arr[i]) min = arr[i];
        }
    }
 
    }
}

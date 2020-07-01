/* find minimum and maximum of array

//brute force: O(nlogn)
// Time Complexity : O(3*(N-1)/2)
// Space Complexity : O(1) in place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//Here we have to reduce the number of comparisons from 2*(N-2)
//in this approach, we will first initialise max and min to the first index value
//then we will consider elements in pair and there will be total of 3 comparisons
//Case we will find smaller or larger among two values and will compare found value with max and min
//finally, update max and min values accordingly
*/

import java.io.*;

class GFG {
    public static void main (String[] args) {
        int n, min, max;
        n = 7;
        //intialising array
        int[] arr = new int[]{2,8,6,2,11,5,70};
        max = arr[0];
        min = arr[0];
        for(int i = 0; i < n; i++){
            if(i == n-1)
            {
                if(arr[i] > max) max = arr[i];
                if(arr[i] < min) min = arr[i];
            }
            else if(arr[i] > arr[i+1])
            {
                if(arr[i] > max) max = arr[i];
                if(arr[i+1] < min) min = arr[i+1];
            }
            else 
            {   if(arr[i+1] > max) max = arr[i+1];
                if(arr[i] < min) min = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}
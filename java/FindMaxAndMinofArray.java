Maximum and minimum of an array using minimum number of comparisons
        Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison


// Time Complexity : O(N)
// Space Complexity : O(1)

    /*    Total number of comparisons: Different for even and odd n, see below:

        If n is odd:    3*(n-1)/2
        If n is even:   1 Initial comparison for initializing min and max,
        and 3(n-2)/2 comparisons for rest of the elements
        =  1 + 3*(n-2)/2 = 3n/2 -2
*/

// Did this code successfully run on Geeks For Geeks : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
check in pairs and store the min and max for each pair so that number of comparisons reduces.

import java.io.*;

class GFG {
    public static void main (String[] args) {
        int arr[] = {1000, 11, 445, 1, 330};
        int arr_size = 5;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }

    static class Pair {

        int min;
        int max;
    }

    static Pair getMinMax(int arr[], int n){
        if (arr==null || n==0) return null;
        Pair minmax = new Pair();

        int i=0, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;

        if(n%2==0){
            if(arr[0]>arr[1]){
                max = arr[0];
                min = arr[1];
            } else {
                max = arr[1];
                min=arr[0];
            }
            i=2;
        } else {
            min = arr[0];
            max = arr[0];
            i=1;
        }



        while (i<n){
            if(arr[i]>arr[i+1]){
                minmax.max = Math.max(max, arr[i]);
                minmax.min = Math.min(min, arr[i+1] );

            } else{
                minmax.max = Math.max(max, arr[i+1]);
                minmax.min = Math.min(min, arr[i] );
            }
            i += 2;
        }
        return minmax;
    }
}

/*
// Time Complexity :O(n) where n is the length of arr array
// Space Complexity :O(1) using no extra space
// Number of comparisions:

   If n is odd:    3*(n-1)/2
   If n is even:   1 Initial comparison for initializing min and max, and 3(n-2)/2 comparisons for rest of the elements
                   =  1 + 3*(n-2)/2 = 3n/2 -2

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
*/

// Java program of above implementation
public class MaxAndMin {

    /* Class Pair is used to return two values from getMinMax() */
    static class Pair {

        int min;
        int max;
    }

    static Pair getMinMax(int arr[], int n) {
        Pair minmax = new Pair();
        int i;

        if (arr == null || arr.length == 0){
            minmax.max = -1;
            minmax.min = -1;
        }
        else {
            /* If array has even number of elements then initialize the first two elements as minimum and maximum */
            if (n % 2 == 0) {
                if (arr[0] > arr[1]) {
                    minmax.max = arr[0];
                    minmax.min = arr[1];
                } else {
                    minmax.min = arr[0];
                    minmax.max = arr[1];
                }
                i = 2;
                /* set the starting index for loop */
            } /* If array has odd number of elements then
	initialize the first element as minimum and
	maximum */ else {
                minmax.min = arr[0];
                minmax.max = arr[0];
                i = 1;
                /* set the starting index for loop */
            }

		/* In the while loop, pick elements in pair and
	compare the pair with max and min so far */
            while (i < n - 1) {
                if (arr[i] > arr[i + 1]) {
                    if (arr[i] > minmax.max) {
                        minmax.max = arr[i];
                    }
                    if (arr[i + 1] < minmax.min) {
                        minmax.min = arr[i + 1];
                    }
                } else {
                    if (arr[i + 1] > minmax.max) {
                        minmax.max = arr[i + 1];
                    }
                    if (arr[i] < minmax.min) {
                        minmax.min = arr[i];
                    }
                }
                i += 2;
			/* Increment the index by 2 as two
			elements are processed in loop */
            }
        }
        return minmax;
    }

    /* Driver program to test above function */
    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);

    }
}


// Time Complexity : O(N) N = #elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class MinAndMaxInArray {

    static int[] getMinMax(int arr[], int n) {
        int min;
        int max;

        if (n == 1) {
            max = arr[0];
            min = arr[0];
            return new int[]{min, max};
        }

        if (arr[0] > arr[1]) {
            max = arr[0];
            min = arr[1];
        } else {
            max = arr[1];
            min = arr[0];
        }

        for (int i = 2; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        return new int[]{min, max};
    }

    /* Driver program to test above function */
    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        int[] minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax[0]);
        System.out.printf("\nMaximum element is %d", minmax[1]);

    }
}

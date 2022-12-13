// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// create a pair for min and maximum comaprision between 2 elements.
// check for every pair and get the minimum and maximum among the pairs;

public class minMax {
    // Java program of above implementation
    class Pair {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    private Pair getMinMax(int[] arr, int arr_size) {

        Pair pair = new Pair();

        if (arr_size == 1) {
            pair.min = arr[0];
            pair.max = arr[1];

            return pair;
        }

        for (int i = 0; i < arr_size - 1; i = i + 2) {
            if (arr[i] > arr[i + 1]) {
                pair.max = Math.max(pair.max, arr[i]);
                pair.min = Math.min(pair.min, arr[i + 1]);
            } else {
                pair.max = Math.max(pair.max, arr[i + 1]);
                pair.min = Math.min(pair.min, arr[i]);
            }
        }

        return pair;

    }

    /* Driver program to test above function */
    public static void main(String args[]) {
        int arr[] = { 2, 1, 3, 4, 5, 6, 7, 8 };
        int arr_size = 8;
        minMax minMaxEle = new minMax();
        Pair minmax = minMaxEle.getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);

    }

}

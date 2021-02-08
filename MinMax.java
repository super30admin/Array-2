/**
Time complexity: O(n)
Space complexity: O(1)
Execute successfully on Leetcode: Yes
Any problems faced: No
*/

public class MinMax {
    /**
    Approach:
    - Divide the array in pairs
    - Each pair will make 3 comparisons
    - If length of array is even, compare and make the first 2 elements as min and max.
    - If length of array is odd, make the first element as min and max.
    - Compare the consecutive pair with the current min and max
    */
    static class Pair {
 
        int min;
        int max;
    }
 
    static Pair getMinMax(int arr[], int n) {
        Pair minmax = new Pair();
        int i;
        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;
        } else {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;
        }
 
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
        }
 
        return minmax;
    }
}

// GFG Maximum and minimum of an array using minimum number of comparisons
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
import java.util.Arrays;

public class MinMaxFinder {

    private static int[] findMinMax(int[] A, int n) {
        int min = A[0], max = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
        }
        int[] result = { min, max };
        return result;
    }

    public static void main(String[] args) {
        int[] A = { 4, 9, 6, 5, 2, 3 };
        int N = A.length;
        System.out.println("Minimum & Maximum element are: " + Arrays.toString(findMinMax(A, N)));
    }
}

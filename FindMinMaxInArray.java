// Approach: We compare array elements in pairs. For every alternate element, we compare it with its following element and update
// the global minimum and maximum. Therefore, for half of the array elements, we make three comparisons, resulting in a total of
// approximately 3n/2 comparisons.
// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

public class FindMinMaxInArray {

    int[] comparePairs(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array can't be null or empty..");
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int i;
        if (arr.length % 2 == 0) {
            min = Math.min(arr[0], arr[1]);
            max = Math.max(arr[0], arr[1]);
            i = 2;
        } else {
            min = max = arr[0];
            i = 1;
        }
        for (; i < arr.length - 1; i += 2) { // Increment i by 2 as 2 elements are processed at once.
            if (arr[i] < arr[i + 1]) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i + 1]);
            } else {
                min = Math.min(min, arr[i + 1]);
                max = Math.max(max, arr[i]);
            }
        }
        return new int[] { min, max };
    }

    public static void main(String[] args) {
        FindMinMaxInArray fmm = new FindMinMaxInArray();
        int[] arr = { 2, -1, 25, 6, 3, -7, 3, 19 };
        int[] ans = fmm.comparePairs(arr);
        System.out.println("Minimum: " + ans[0] + "\nMaximum: " + ans[1]);
    }
}
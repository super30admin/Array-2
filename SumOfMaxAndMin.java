// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Cutting comparisons to 3 per pair by comparing a pair; then comparing
// bigger element with max and smaller with min. For odd numbers, compare one more 
// time with max and min at the end

class SunmOfMaxAndMin {
    public static int findSum(int A[], int N) {
        // if there's one element; it is max and min both
        if (N == 1)
            return A[0] * 2;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // even numbers are perfect pairs; for odd numbers one more comparison is
        // required
        int endAtIndex = N % 2 == 0 ? N : N - 1;

        for (int i = 0; i < endAtIndex; i += 2) {
            // compare the bigger number with max
            // compare the smaller number with min
            if (A[i] > A[i + 1]) { // 1st comparison
                max = Math.max(max, A[i]); // 2nd comparison
                min = Math.min(min, A[i + 1]); // 3rd comparison
            } else {
                max = Math.max(max, A[i + 1]); // 2nd comparison
                min = Math.min(min, A[i]); // 3rd comparison
            }
        }
        // compare last element
        // odd numbers; two more comparisons is required
        if (N % 2 == 1) {
            max = Math.max(max, A[N - 1]); // 2nd comparison
            min = Math.min(min, A[N - 1]);
        }

        return max + min;
    }
}
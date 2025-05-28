/*
 * Question:
 * Find both the minimum and maximum in an unsorted integer array using fewer than 2*(n-1) comparisons.
 *
 * Approach: Tournament Method (Pairwise Comparison)
 * → Instead of comparing each element individually (2*(n-1) comparisons),
 *   we compare elements in pairs, reducing comparisons to roughly 1.5 * n.
 *
 * Steps:
 * 1. If n is even:
 *    → Compare first two elements to initialize min and max.
 *    → Start loop from index 2
 * 2. If n is odd:
 *    → Initialize min and max with nums[0].
 *    → Start loop from index 1
 * 3. Loop through array in steps of 2:
 *    → Compare the pair first, then update min and max accordingly.
 *    → Only 3 comparisons per 2 elements (vs. 4 in naive approach)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Example:
 * nums = [4, 9, 6, 5, 2, 3]
 * → Comparisons: 3 pairs → 3 * 3 = 9 comparisons (instead of 10 in naive)
 */

import java.util.Arrays;

class Problem_3 {

    static int[] minmaxfinder(int[] nums) {
        int[] res = { Integer.MAX_VALUE, Integer.MIN_VALUE };
        int n = nums.length;
        int i = 0;
        if (n % 2 == 0) {
            if (nums[0] < nums[1]) {
                res[0] = nums[0];
                res[1] = nums[1];
            } else {
                res[0] = nums[1];
                res[1] = nums[0];
            }
            i = 2;
        } else {
            res[0] = nums[0];
            res[1] = nums[0];
            i = 1;
        }
        while (i < n - 1) {
            if (nums[i] < nums[i + 1]) {
                res[0] = Math.min(res[0], nums[i]);
                res[1] = Math.max(res[1], nums[i + 1]);
            } else {
                res[1] = Math.max(res[1], nums[i]);
                res[0] = Math.min(res[0], nums[i + 1]);
            }
            i += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 9, 6, 5, 2, 3 };
        int[] result = minmaxfinder(nums);
        System.out.println(Arrays.toString(result));
    }
}

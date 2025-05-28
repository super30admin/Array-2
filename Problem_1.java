/*
 * Question:
 * Given an array of integers where 1 ≤ nums[i] ≤ n (n = size of array),
 * some elements appear twice and others once.
 * Find all elements in the range [1, n] that do not appear in the array.
 *
 * Approach: Cyclic Sort
 * → The correct position of each number `x` is index `x - 1`.
 * → Loop through the array, and place each element at its correct index using swaps.
 * → After sorting:
 *    → If at index `i`, nums[i] != i+1 → then (i+1) is missing.
 * → Add such numbers to the result list.
 *
 * Example:
 * Input:  [4,3,2,7,8,2,3,1]
 * Sorted: [1,2,3,4,3,2,7,8]
 * Missing: [5,6]
 *
 * Time Complexity: O(n) — Each element is moved at most once.
 * Space Complexity: O(1) — No extra space used except output list.
 */

import java.util.ArrayList;
import java.util.List;

class Problem_1 {
    static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums.length) {
            int correctidx = nums[i] - 1;
            if (nums[correctidx] != nums[i]) {
                int temp = nums[correctidx];
                nums[correctidx] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        int j = 0;
        while (j < nums.length) {
            int ans = j + 1;
            if (ans != nums[j]) {
                result.add(ans);
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        int[] nums2 = { 1, 1 };
        List<Integer> result = findDisappearedNumbers(nums);
        List<Integer> result2 = findDisappearedNumbers(nums2);
        System.out.println(result.toString());
        System.out.println(result2.toString());
    }
}

// Approach: There are two scenarios in this algorithm: If a number i between 1 and n is present in the array, its correct position
// would be i-1. If it is not present, some other number d is duplicated. The correct position for the duplicated number d is d-1. We
// repeatedly swap the element at the current position with the element at its correct position until one of these scenarios occurs.
// This algorithm is called Cyclic Sort.
// Time Complexity: O(n) where n - array size
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FindMissing1toN {

    int[] cyclicSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; ) {
            int correctPos = arr[i] - 1;
            if (arr[i] != arr[correctPos]) {
                int t = arr[i];
                arr[i] = arr[correctPos];
                arr[correctPos] = t;
            } else {
                i++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        FindMissing1toN fm = new FindMissing1toN();
//        int[] arr = { 3, 2, 3 };
        int[] arr = { 2, 6, 2, 3, 4, 5, 3, 4 }; // array of size 8
        System.out.println(Arrays.toString(fm.cyclicSort(arr))); // prints 1, 7, 8
    }
}
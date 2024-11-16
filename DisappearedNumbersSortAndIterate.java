/*
1. Time Complexity: O(nlogn)+O(n)=O(nlogn).

     Sorting:
        Sorting the array using Arrays.sort() (Timsort) takes O(nlogn) time in the worst case, as sorting is the most
        expensive operation in this approach.

     Iterating Through the Array:
        After sorting, we iterate through the array to find the missing numbers, which takes O(n) time.

        Total Time Complexity: O(nlogn)+O(n)=O(nlogn).

2. Space Complexity: O(1)
    Question says, You may assume the returned list does not count as extra space.

Did this code successfully run on Leetcode: Yes

DISCLAIMER: THIS CHANGES THE INPUT ARRAY, SAME WITH SWAP APPROACH SO HAVE NOT SOLVED IT
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DisappearedNumbersSortAndIterate {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        Arrays.sort(nums);
        int expected = 1;
        List<Integer> missingNumbers = new ArrayList<>();

        for(int num : nums)
        {
            while(num > expected)
            {
                missingNumbers.add(expected);
                expected++;
            }

            if(num == expected) {
                expected++;
            }
        }

        while(expected <= nums.length) {
            missingNumbers.add(expected);
            expected++;
        }

        return missingNumbers;
    }
}
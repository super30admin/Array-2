/*
Time Complexity: O(n)

    The solution contains two loops, each iterating over the array of size n.
    The first loop takes O(n) time to insert elements into the HashSet,
        The HashSet stores all the elements of the input array nums. In the worst case, all numbers from 1 to n are
        present in nums, so the set will contain n elements.

    and the second loop takes O(n) time to check if each number from 1 to n is in the HashSet.

    Therefore, the total time complexity is O(2n), which simplifies to

    O(n) in Big-O notation (ignoring constant factors).

Space Complexity: O(n)
    The space complexity is O(n) for the HashSet (set).

Did this code successfully run on Leetcode: Yes
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class DisappearedNumbersUsingHashSet {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        List<Integer> missingNumbers = new ArrayList<>();

        for(int num : nums)
        {
            set.add(num);
        }

        for(int i = 0; i<n; i++)
        {
            if(!set.contains(i+1)) {
                missingNumbers.add(i+1);
            }

        }

        return missingNumbers;
    }
}

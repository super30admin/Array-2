/*
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
Intuition: I used a HashSet to store the numbers present in the array.
Then I checked for numbers from 1 to n (where n is the length of the array) and added the missing numbers to a list.
This way, I can efficiently find all the numbers that are not present in the array.
*/

import java.util.*;

class DissapearedNumbersInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        for (int i : nums)
            h.add(i);
        for (int i = 1; i <= nums.length; i++) {
            if (!h.contains(i))
                l.add(i);
        }
        return l;
    }

    public static void main(String[] args) {
        DissapearedNumbersInArray solution = new DissapearedNumbersInArray();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> result = solution.findDisappearedNumbers(nums);
        System.out.println(result); // Output: [5, 6]
    }
}

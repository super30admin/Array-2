/*
Time Complexity: O(n)
    First loop: The loop that iterates through nums takes O(n) time, where n is the size of the input array.

    Second loop: The second loop, which checks the boolean array arr to find the missing numbers, also takes
    O(n) time.

    Thus, the total time complexity is:

    O(n) for the first loop + O(n) for the second loop = O(2n).

    Since constants are ignored in Big-O notation, the final time complexity is: O(n).

Space Complexity: O(n)
    Boolean Array arr: The boolean array arr of size n is the only extra space used in the algorithm

Did this code successfully run on Leetcode: Yes

*/

import java.util.ArrayList;
import java.util.List;

class DisappearedNumbersUsingArrays {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] arr = new boolean[n];
        List<Integer> missingNumbers = new ArrayList<>();

        for(int num : nums)
        {
            arr[num-1] = true;
        }

        for(int i = 0; i<n; i++)
        {
            if(arr[i] == false) {
                missingNumbers.add(i+1);
            }
        }

        return missingNumbers;
    }
}
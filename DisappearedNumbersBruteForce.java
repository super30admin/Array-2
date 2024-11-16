/*
Time Complexity : O(n^2)
    Outer loop runs n times.
    Inner loop runs n times for each iteration of the outer loop.

Space Complexity : O(1)
    Question says, You may assume the returned list does not count as extra space.
    This approach is straightforward but inefficient for large arrays, as it involves nested loops.

Did this code successfully run on Leetcode: No Time Limit Exceeded

*/

import java.util.ArrayList;
import java.util.List;

class DisappearedNumbersBruteForce {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        //Brute Force
        int n = nums.length;
        List<Integer> missingNumbers = new ArrayList<>();

        for(int i=1; i<=n; i++) //Iterating from 1 to n elements, if array size is 8, we should have 8 consecutive elements
        {
            boolean found = false;

            for(int num : nums) //Iterating over array
            {
                if(i == num)
                {
                    found = true;
                    break;
                }
            }

            if(!found)
                missingNumbers.add(i);
        }

        return missingNumbers;
    }
}
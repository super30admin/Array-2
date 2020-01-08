from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        """
            // Time Complexity : O(n)
                    'n' is the number of elements in the list
            // Space Complexity : O(1)
            // Did this code successfully run on Leetcode : Yes
            // Three line explanation of solution in plain english
                    - For each value in the list,we change the corresponding
                      index - 1 to negative to mark the presence of that number.
                    - All values in the list, which are positive, the corresponding
                      index + 1 is the number missing from the list.
            // Other approaches -
                    - Use hash set, loop over from 1 to n. O(n) Time and space
                    - Sort the list, loop over to find the missing numbers.
                            O(nlogn) Time  and O(1) space
        """
        result = []
        # edge case
        if not nums:
            return result

        for i in range(len(nums)):
            nums[abs(nums[i]) - 1] = -1 * abs(nums[abs(nums[i]) - 1])

        return [index + 1 for index, num in enumerate(nums) if num > 0]

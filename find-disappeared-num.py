# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        result = []  # to store the missing numbers

        # make the number negative for corressponding index

        for i in range(len(nums)):
            # making it as a new temporary negative index
            new_index = abs(nums[i]) - 1

            if nums[new_index] > 0:  # making it negative indicating that nums[i] has visited or appeared
                nums[new_index] = nums[new_index] * -1

        # take corressponding values of positive index

        for i in range(1, len(nums) + 1):  # iterating over 1 to n values
            if nums[i - 1] > 0:
                # add all the values in the array those are positive
                result.append(i)

        return result

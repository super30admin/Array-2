"""
time - o(n)
space - o(1)
we take each number in the array and head to the array[number] (using the number as an index)
we make this number as negative, any number that is missing will have array[number] as positive
"""

from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            nums[abs(nums[i]) - 1] *= -1 if nums[abs(nums[i]) - 1] > 0 else 1
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
        return result

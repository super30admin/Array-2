"""
Problem: Find All Numbers Disappeared in an Array
TC: O(n) SC: O(1)
Approach: Traverse the array and mark the visited indices. Traverse the array again and find the missing elements.
"""



from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        n = len(nums)

        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = -1 * nums[index]

        for i in range(n):
            if nums[i] > 0:
                result.append(i + 1)

        return result

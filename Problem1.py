"""
TC: O(N) {We only iterate linearly in the array}
SC: O(1) {we modify the given array in place, hence no extra space used.}

Approach:

We first iterate through the elements of array and since we know all the elements that exists are in range 1-n, we modify the
element at the idx (value of the element) to make it negative. Once we do that for every element, we are then left with only the indices
which were missing in the array (ie if they are positive, not modified).

We pass the next time and store the indices of the positive elements of the array in the result array.

The problem ran successfully on Leetcode.
"""

from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            idx = abs(nums[i])-1
            nums[idx] *= -1 if nums[idx] > 0 else 1
        res = []
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
        return res
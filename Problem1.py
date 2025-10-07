# Time Complexity : O(n)  # We traverse array twice
# Space Complexity : O(1) # Ignoring the result array, we only use variables in-place
# Did this code successfully run on Leetcode : Yes
# Approach :
# 1. Use the values as indices: mark the index (num-1) as negative to say "this number exists".
# 2. After marking, indices that remain positive were never visited.
# 3. Those indices + 1 are the missing numbers.

from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)

        # First pass: mark numbers as seen by making their index negative
        for i in range(n):
            idx = abs(nums[i]) - 1    # map number to index (1 → 0, 2 → 1, ... n → n-1)
            if nums[idx] > 0:         # only flip if it's not already negative
                nums[idx] *= -1       # mark index as visited

        # Second pass: collect missing numbers
        result = []
        for i in range(n):
            if nums[i] > 0:           # if still positive → index never marked → number missing
                result.append(i + 1)  # convert back to 1-based number

        return result

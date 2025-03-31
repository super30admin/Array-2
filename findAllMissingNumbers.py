# Mark numbers as negative to track presence, then collect missing numbers
# TC: O(n) Iterate twice over the list
# SC O(1) In-place modification, ignoring the result list
from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return []

        result = []
        n = len(nums)

        # Mark the presence of numbers by making the value at the corresponding index negative
        for i in range(n):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] = -nums[idx]

        # Collect all indexes that are still positive (missing numbers)
        for i in range(n):
            if nums[i] > 0:
                result.append(i + 1)
            else:
                nums[i] = -nums[i]  # Restore original value

        return result


sol = Solution()
arr1 = [4, 3, 2, 7, 8, 2, 3, 1]
print(sol.findDisappearedNumbers(arr1))

"""
Time Complexity: O(n)
Space Complexity: O(1)
"""

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        solution = []
        for i in range(0, len(nums)):
            if nums[abs(nums[i]) - 1] > 0:  # so that index is not affected by negative value.
                nums[abs(nums[i]) - 1] *= -1

        for i in range(len(nums)):
            if nums[i] > 0:
                solution.append(i + 1)

        return solution

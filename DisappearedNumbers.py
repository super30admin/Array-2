# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Mark corresponding index of each number negative.
# If any index remains positive then that number is missing from array.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i, num in enumerate(nums):
            idx = abs(num) - 1

            if nums[idx] > 0:
                nums[idx] *= -1
                
        res = []

        for i, num in enumerate(nums):
            if num > 0:
                res.append(i+1)

        return res
        
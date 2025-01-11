# Time Complexity = O(n)
# Space Complexity = O(1)
# Leetcode = Yes
# Approach = This solution marks indices corresponding to each number in the array as negative to indicate presence. In a second pass, indices with positive values are collected as the missing numbers.
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for n in nums:
            index = abs(n) -1
            nums[index] = -1 * abs(nums[index])
        res = []
        for i,n in enumerate(nums):
            if n > 0:
                res.append(i+1)
        return res
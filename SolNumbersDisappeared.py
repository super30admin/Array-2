"""
Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

TC = O(N) and SC = O(1) 
(because we are using space to return the result not as an extra space)
"""

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(0, len(nums)):
            index = abs(nums[i])
            if nums[index-1] > 0:
                nums[index-1] *= -1
        result = []
        for i in range(0, len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return result
            
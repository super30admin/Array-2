# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for num in nums:
            index = (abs(num) - 1)
            nums[index] = (-abs(nums[index]))
        return [(i + 1) for i, num in enumerate(nums) if num > 0]
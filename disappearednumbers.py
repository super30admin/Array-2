##Time Complexity : O(n)
##Space Complexity :O(1)
##Did this code successfully run on Leetcode : Yes

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for n in nums:
            i = abs(n) - 1
            nums[i] = -1 * abs(nums[i])
        result = []
        for i, n in enumerate(nums):
            if n > 0:
                result.append(i+1)
        return result
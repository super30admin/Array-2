# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i in range(len(nums)):
            element = abs(nums[i])
            if nums[element-1]>0:
                nums[element-1] = nums[element-1]*-1
                
        res = []
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)
                
        return res       
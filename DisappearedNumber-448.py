# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach 

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        for num in nums:
            index = abs(num) - 1
            if nums[index] > 0:
                nums[index] *= -1
     
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
        
        return res
            
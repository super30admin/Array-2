# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# Easy approach just make the indexes which are present to negative
# so the positive ones are missing. 


class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        n = len(nums)
        for i in range(0,n):
            index = abs(nums[i])-1
            if(nums[index] > 0):
                nums[index]*=-1
        for i in range(0,n):
            if(nums[i]>0):
                res.append(i+1)
        return res
        

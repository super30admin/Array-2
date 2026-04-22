# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n=len(nums)
        res=[]
        
        for i in range(n):
            ind = abs(nums[i])-1
            if nums[ind]>0:
                nums[ind]*=-1

        for i in range(n):
            if nums[i]>0:
                res.append(i+1)
            

        return res
"""
time: O(n)
space: O(n)
Leet: Accepted
Problems: None
"""

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        #Mark index representing number that is in the list as negetive
        for i in range(len(nums)):
            index = abs(nums[i])-1
            nums[index] = - abs(nums[index])

        res=[]
        #Add positive indices to result
        for j in range(len(nums)):
            if nums[j] >= 0:
                res.append(j+1)

        return res

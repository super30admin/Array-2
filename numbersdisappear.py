class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result=[]
        n=len(nums)
        for val in range(1,len(nums)+1):
            if val not in nums:
                result.append(val)
        return result
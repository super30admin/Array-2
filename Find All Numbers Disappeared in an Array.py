# TC : O(n)
# SC : O(1)
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result=[]
        for i in nums:
            if nums[abs(i)-1]>0:
                nums[abs(i)-1]*=-1
        for  i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
                
        return result
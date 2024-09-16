#TimeComplexity : O(N) where N is number of inputs
#Space Complexity : O(1) as no space is used
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = []
        for i in range(len(nums)):
            if (nums[abs(nums[i])-1]) > 0:
                nums[abs(nums[i])-1]*=-1
               
        
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return result

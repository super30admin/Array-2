#TimeComplexity:O(N) 
#SpaceComplexity: Constant Space (No Extra space taken).
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if len(nums)==0:
            return 
        output=[]
        for i in range(len(nums)):
            if nums[abs(nums[i])-1]>0:
                nums[abs(nums[i])-1]*=-1
        for i in range(len(nums)):
            if nums[i]>0:
                output.append(i+1)
        return output

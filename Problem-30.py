#Find All Numbers Disappeared in an Array -448
# time complexity =O(N)
#space complexity =O(1)
# Approach - Here we need to subract each element by -1 and if that difference is greater than 1, we need to multiply by -1 at particular difference index. later on we need to return elements that are positive in that array.

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        
        """
        result=[]
        if nums==[] or len(nums)==0:
            return result
        for i in range(len(nums)):
            idx=abs(nums[i])-1
            if nums[idx]>0:
                nums[idx]*=-1
        
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
        
        return result
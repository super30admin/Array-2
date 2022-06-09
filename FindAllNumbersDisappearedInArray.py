#TC: O(n)
# SC: O(1)
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        li=[]
        for i in range(len(nums)):
            idx=abs(nums[i])-1
            if(nums[idx]>0):
                nums[idx]=nums[idx]*(-1)
                
        for i in range(len(nums)):
            if nums[i]>0:
                li.append(i+1)
        return li
                
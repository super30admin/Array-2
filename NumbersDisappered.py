"""
//Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if len(nums)==0:
            return []
        result = []
        for i in range(0,len(nums)):
            index = abs(nums[i]) - 1
            if nums[index]>0:
                nums[index]=nums[index]*(-1)
        for i in range(0,len(nums)):
            if nums[i]>0:
                result.append(i+1)
            else:
                nums[i]=nums[i] * -1
        return result

        
        # a = set()
        # b= []
        # for i in range(0,len(nums)):
        #     a.add(nums[i])
        # for i in range(1,len(nums)+1):
        #     if i not in a:
        #         b.append(i)
        # return b
# -*- coding: utf-8 -*-
"""
Created on Thu Feb  6 12:57:43 2020

@author: WELCOME
"""

"""
Find diappeared numbers
Time - O(N)
Space - O(1)
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        result=[]
        for i in range(len(nums)):
            nums[abs(nums[i])-1]=-1*abs(nums[abs(nums[i])-1])
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
        return result
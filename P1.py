# -*- coding: utf-8 -*-
"""
Created on Tue Apr  6 11:19:49 2021

@author: jgdch
"""

#Time Complexity: O(N), where N is the length of the input array
#space Complexity:O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        out=[]
        for i in range(len(nums)):
            j=abs(nums[i])-1
            if nums[j]>0:
                nums[j]*=-1
        print(nums)
        for i in range(len(nums)):
            if(nums[i]>0):
                out.append(i+1)
        return out
                
        
        
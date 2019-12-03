#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Dec  3 09:59:29 2019

@author: tanvirkaur
"""
# Time complexity = O(n)
# Space complexity = O(1)
# Number of comparisions = 3n/2

class Solution(object):
    def maxmin(self, nums):
        if not nums:
            return None
        minn = nums[0]
        maxx = nums[0]
        for i in range(1,len(nums),2):
            if i == len(nums)-1:
                minn = min(minn,nums[i])
                maxx = max(maxx,nums[i])
            elif nums[i] > nums[i+1]:
                maxx = max(nums[i],maxx)
                
            elif nums[i] < nums[i+1]: 
                minn = min(nums[i], minn)
        return maxx, minn
    
obj = Solution()
nums = [-14,2,0,4,5,6,-1,14]
print(obj.maxmin(nums))
                
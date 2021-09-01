#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 31 21:11:05 2021

@author: ameeshas11
"""


#Time Complexity : O(n)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        output = []
        #make the number negative for corressponding index
        for i in range(len(nums)):
            temp = abs(nums[i])-1
            nums[temp] = abs(nums[temp]) * -1
         
        #take corressponding values of positive index
        for i in range(len(nums)):
            if nums[i]>0:
                output.append(i+1)
                
        return output
        
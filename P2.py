# -*- coding: utf-8 -*-
"""
Created on Tue Apr  6 11:20:04 2021

@author: jgdch
"""

#Time Complexity: O(N), where N is the length of the input array
#space Complexity:O(1)
#Number of comparisions: (3n)/2
def minmax(nums):
    min_num=float("Inf")
    max_num=float("-Inf")
    for i in range(0,len(nums),2):
        if(nums[i]>nums[i+1]):
            if(nums[i]>max_num):
                max_num=nums[i]
            if(nums[i+1]<min_num):
                min_num=nums[i]
        else:
            if(nums[i+1]>max_num):
                max_num=nums[i]
            if(nums[i]<min_num):
                min_num=nums[i]
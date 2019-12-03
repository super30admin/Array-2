#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Dec  3 08:56:55 2019

@author: tanvirkaur
"""
# Time complexity = O(n)
# Space complexity = O(1)
# by making the numbers negative we are saying that the element is present in the array
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        if not nums:
            return None
        for i in range(len(nums)):
            x = abs(nums[i])
            if nums[x-1] > 0:
                nums[x-1] = -nums[x-1]
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
        return res
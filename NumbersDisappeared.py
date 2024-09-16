#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Dec  3 08:41:47 2019

@author: tanvirkaur
"""

# Brute Force Solution
# Time complexity = O(n^2)
# Space complexity = O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        for i in range(1,len(nums)+1):
            if i not in nums:
                res.append(i)
        return res
                
                
        
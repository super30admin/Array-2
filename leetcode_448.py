#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb 22 13:48:52 2026

@author: rishigoswamy

    LeetCode 448: Find All Numbers Disappeared in an Array
    Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

    Approach:
    Cyclic Sort (Index Placement Technique)

    Since:
        1 ≤ nums[i] ≤ n
    Each value v ideally belongs at index v - 1.

    We iterate through the array and:
        - While the current number is not in its correct position
        - And it is not a duplicate
        → Swap it to its correct index.

    After placement:
        Any index i where nums[i] != i + 1
        indicates that (i + 1) is missing.

    // Time Complexity : O(n)
        Each element is swapped at most once into its correct position.
    // Space Complexity : O(1)
        In-place modification (excluding output list).
"""

from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        for i in range(0, len(nums)):
            swapIdx = nums[i]
            while nums[i] != swapIdx-1 and not nums[swapIdx-1] == nums[i]:
                nums[swapIdx-1], nums[i] = nums[i], nums[swapIdx-1]
                swapIdx = nums[i]

        
        res = []
        for i in range(0, len(nums)):
            if nums[i]-1 != i:
                res.append(i+1)
        
        return res


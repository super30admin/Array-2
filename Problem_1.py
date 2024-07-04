"""
## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
"""

# Approach: using boolean array to store present nums as True
# TC: O(N) ; SC: O(N)

from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return []

        max_num = len(nums)
        
        res = []
        new_arr = [False] * (max_num + 1)
        
        for num in nums:
            new_arr[num] = True
            
        for i in range(1, max_num + 1):
            if not new_arr[i]:
                res.append(i)
                
        return res

# Approach: getting negative nums
# TC: O(n); SC:O(1)


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        
        for num in nums:
            idx = abs(num) - 1
            
            if nums[idx] > 0:
                nums[idx] = -nums[idx]
                
            
        res = []
        
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i + 1)
                
                
        return res
             

       

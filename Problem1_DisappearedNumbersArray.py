'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 448. Find All Numbers Disappeared in an Array

# Given an array nums of n integers where nums[i] is in the range [1, n], 
# return an array of all the integers in the range [1, n] that do not appear 
# in nums.

# Example 1:
# Input: nums = [4,3,2,7,8,2,3,1]
# Output: [5,6]

# Example 2:
# Input: nums = [1,1]
# Output: [2]

# Follow up: Could you do it without extra space and in O(n) runtime? 
# You may assume the returned list does not count as extra space.

#-----------------
# Time Complexity: 
#-----------------
# O(N): Where N is the size of the matrix. Need to iterate over array twice.

#------------------
# Space Complexity: 
#------------------
# O(1): Not using any auxiliary data structure. 
#       Only variables i, val, and n. So constant space.

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             : 456 ms  ( 8.36 %ile)
# Space            : 21.8 MB (82.35 %ile)

from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = []

        if n == 1:
            return result
        
        else:

            for i in range(n):
                val = abs(nums[i]) - 1
                if nums[val] > 0:
                    nums[val] *= -1

            for i in range(n):
                if nums[i] > 0:
                    result.append(i+1)

            return result
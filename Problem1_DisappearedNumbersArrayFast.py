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
# Time             : 344 ms  (65.49 %ile)
# Space            : 25.3 MB (20.57 %ile)

from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        return list({i for i in range(1, len(nums) + 1)} - set(nums))

        
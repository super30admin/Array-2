'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# Array Min Max

# Given an array of numbers of length N, find both the minimum and maximum. 
# Follow up : Can you do it using less than 2 * (N - 2) comparison

#-----------------
# Time Complexity: 
#-----------------
# O(N): Requires 3(n/2) comparisons. We traverse the array 2 at a time, hence
#       n/2. Each traversal requires 3 comparisons.

#------------------
# Space Complexity: 
#------------------
# O(1): Not using any auxiliary data structure. Just min and max variables

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: N/A

from typing import List
class Solution:
    def findMinMax(self, nums: List[int]) -> List[int]:
        n = len(nums)
        max_val = None
        min_val = None
        next_index = None

        if n==0:
            return []

        elif n%2 != 0:
            max_val = min_val = nums[0]
            next_index = 1

        else:
            max_val = max(nums[0], nums[1])
            min_val = min(nums[0], nums[1])
            next_index = 2

        for i in range(next_index, n-1, 2):
            if nums[i] < nums[i+1]:
                min_val = min(min_val, nums[i])
                max_val = max(max_val, nums[i+1])
            else:
                max_val = max(max_val, nums[i])
                min_val = min(min_val, nums[i+1])
            

        return [min_val, max_val]


obj = Solution()
print(obj.findMinMax([1,2,3,5]))


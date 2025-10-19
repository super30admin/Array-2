from typing import List
import math

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
Problem:
Given an array of numbers of length N, find both the minimum and maximum. 
Follow up : Can you do it using less than 2 * (N - 2) comparisons?
'''

'''
Iterate in pairs instead of going 1 by 1.
'''
def findMaxMin(nums: List[int]) -> (int, int):
    i = 0
    maxVal = float('-inf')
    minVal = float('inf')

    # Check if next element is available
    while i+1 < len(nums):
        maxVal = max(maxVal, max(nums[i], nums[i+1]))
        minVal = min(minVal, min(nums[i], nums[i+1]))

        i+=2

    if i < len(nums):
        maxVal = max(maxVal, nums[i])
        minVal = min(minVal, nums[i])

    return minVal, maxVal

# Test
a1 = [3,1,5,2,8,9,4,3,23]
a2  [1]
a3 = []
a4 = [3,3,3]
print(a1, findMaxMin(a1))
print(a2, findMaxMin(a2))
print(a3, findMaxMin(a3))
print(a4, findMaxMin(a4))
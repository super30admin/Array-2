# Problem 1 -  Find All Numbers Disappeared in an Array
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
The challenge was to find a solution without using an additional array. It took time to come up with the idea of marking the 
number as negative at the index corresponding to its presence in the array.
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        length = len(nums)
        # Store the missing number in result
        result = []
        for i in range (length):
            # number at nums[i] will be consider as index for marking the number at that index ie. to mark that number as present in the array
            index = abs(nums[i]) - 1 
            # mark the number at the index if the number is positive
            if nums[index] > 0 :
                nums[index] *= -1
        # Now find the positive number and store the index of that number which is missing
        for i in range(length):
            if nums[i] > 0:
                result.append(i+1)
        return result 
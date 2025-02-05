# https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

# take the abs of the number - 1 as index and negate it if its not already negative
# in the 2nd pass append all the indices + 1 into result list as they are the numbers that are missing

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        for i in range(len(nums)):
            idx = abs(nums[i]) - 1
            if(nums[idx] > 0):
                nums[idx] *= -1
        
        result = []
        for i in range(len(nums)):
            if(nums[i]>0):
                result.append(i+1)
        
        return result
        
# Array-2

## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

#Approach
# Set n as the abs of all the values in nums list. The nums values start from 1 and idx from 0 so at each iteration set index as value-1
# If value at the index is positive, multiply it with -1 and make it negative. Traverse through this new array which will have positive value on at the index whose value is missing
# Append the index+1 value to res list, conver it back to positive as it is a good practice to not change the given array and return the res

# Time Complexity: O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        for i in range(len(nums)):
            n = abs(nums[i])
            idx = n-1
            if (nums[idx]>0):
                nums[idx] *= -1
            
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
            else:
                nums[i] *= -1
        
        return res
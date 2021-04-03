# Array-2

## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        #APPROACH - 1: STATE CHANGE
        res =[]
        for i in range(len(nums)):
            key = nums[i]
            if key <0:
                key = abs(key)
            if nums[key-1]>0:
                nums[key-1] = nums[key-1] *-1
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)
        return res
        
        <!-- #Time Complexity: O(n), n - length of nums
        #Space Complexity: O(1) -->
    
        
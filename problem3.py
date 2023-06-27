"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

## Problem2
Given an array of numbers of length N, find both the minimum and maximum.
Follow up : Can you do it using less than 2 * (N - 2) comparison
"""

class Numbers:
    def max_and_min(self, nums):
        """
        Using two comparision 
        """
        if len(nums) == 0: return 0
        
        res = [float("inf"), float("-inf")]
        
        for i in range(len(nums)):
            if nums[i] < res[0]:
                res[0] = nums[i]
            elif nums[i] > res[1]:
                res[1] = nums[i]
            
        return res
    
    def max_and_min_2(self, nums):
        """
        using singal comparision
        """
        if len(nums) == 0: return 0
        res = [float("inf"), float("-inf")]
        
        for i in range(0, len(nums), 2):
            if nums[i] > nums[i + 1]:
                res[1] = max(res[1], nums[i])
                res[0] = min(res[0], nums[i + 1])
            else:
                res[1] = max(res[1], nums[i + 1])
                res[0] = min(res[0], nums[i])
                
        return res
        

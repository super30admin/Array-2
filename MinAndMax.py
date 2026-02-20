# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Scan the array in pairs.


class Solution:
    def getMinMax(self, nums):
        # code here
        n = len(nums)
        i = 0
        
        if n % 2 == 0:
            if nums[0] < nums[1]:
                min_val = nums[0]
                max_val = nums[1]
            else:
                min_val = nums[1]
                max_val = nums[0]
            i = 2
        else:
            min_val = max_val = nums[0]
            i = 1
            
            
        while i < n - 1:
            if nums[i] < nums[i + 1]:
                min_val = min(min_val, nums[i])
                max_val = max(max_val, nums[i + 1])
            else:
                min_val = min(min_val, nums[i + 1])
                max_val = max(max_val, nums[i])
            i += 2

        return [min_val, max_val]

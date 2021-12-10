'''
// Time Complexity : O(n). The comparison will take 1.5*N + 1
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Approach:
1.  
'''
class Solution:
    def find_min_and_max(self, nums):
        if len(nums) == 0: return 0
        if len(nums) == 1: return nums[0]

        max_int, min_int = float('-inf'), float('inf')
        while i < len(nums):
            if len(nums) % 2 == 1 and i == len(nums) - 1:
                max_int = max(max_int, nums[i])
                min_int = min(min_int, nums[i])
            elif nums[i] > nums[i+1]:
                max_int = max(max_int, nums[i])
                min_int = min(min_int, nums[i+1])
            else:
                max_int = max(max_int, nums[i+1])
                min_int = min(min_int, nums[i])
            
            i += 2

        return [min_int, max_int]

            
'''https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
Given an array nums of n integers where nums[i] is in the range [1, n], 
return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
'''

# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums is None or len(nums) == 1: return []
        
        res = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1 # the original position of nums[i]
            if nums[index] > 0: 
                nums[index] *= -1 # mark the index element as visited
        
        for i in range(len(nums)):
            if nums[i] > 0: # i+1 is not present
                res.append(i+1)
                nums[i] *= -1 # revert back to original number
        
        return res
        
                
                
            
            
            
        
# Time Complexity:- O(n)
# Space Complexity:- O(1)
# Approach:- For every number take the mod value of the number go to the value-1 index and mark the number there as negative.
# Again iterate and check which index has positive values those are the numbers that are missing
class Solution:
    def findDisappearedNumbers(self, nums):
        for i in range(len(nums)):
            index = abs(nums[i])-1
            nums[index] = -abs(nums[index])            
            
        return [index for index, n in enumerate(nums, start=1) if n > 0]
                
            
            
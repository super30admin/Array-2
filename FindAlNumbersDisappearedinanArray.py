# Time Complexity : O(n) where n : length of input array
# Space Complexity : O(1)

from typing import List
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Edge case
        if not nums:
            return []
        
        # Iterate through the array and mark the elements as negative
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            nums[index] = -abs(nums[index])
        
        # Collect all the positive indices
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
                
        return result

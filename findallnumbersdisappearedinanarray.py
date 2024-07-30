from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Mark each number's corresponding index as visited by making it negative
        for i in range(len(nums)):
            # Get the value of the current element
            currNum = abs(nums[i])
            # Calculate the index that this number should mark
            idx = currNum - 1
            # Mark the number at this index as visited by making it negative
            if nums[idx] > 0:
                nums[idx] = -nums[idx]
        
        # Collect all indices that are still positive, indicating missing numbers
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
        
        return result
# time Compl;exity - O(n)
# Space Complexity - O(1)
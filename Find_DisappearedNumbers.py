# Approach: Iterate through the array and for each number encountered, mark its corresponding index as negative to indicate that the number at that index exists in the array.
# After marking, any index that remains positive corresponds to a missing number (since its position was never visited).
# Finally, collect all indices with positive values, as they represent the numbers missing from the array.

# Time Complexity: O(n), where n is the length of the array, as we iterate over the array a constant number of times.
# Space Complexity: O(1), since we are modifying the input array in place and not using additional space (excluding the result list).
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Mark indices as negative based on values in the array
        for num in nums:
            index = abs(num) - 1  # Find the index corresponding to the value
            if nums[index] > 0:
                nums[index] = -nums[index]  # Mark the element at this index as negative
        
        # Collect all indices where the values are still positive
        result = [i + 1 for i in range(len(nums)) if nums[i] > 0]
        return result

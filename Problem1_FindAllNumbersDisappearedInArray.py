# Time Complexity : O(n) where n is the length of the array
# Space Complexity : O(1) excluding the output array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use the array itself as a hashmap by marking indices as negative.
# For each number, mark the index (number - 1) as visited by making it negative.
# After processing, indices with positive values indicate missing numbers.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Mark indices as visited by making values negative
        for num in nums:
            # Get the absolute value to handle already negated numbers
            index = abs(num) - 1
            # Mark as visited by making it negative
            if nums[index] > 0:
                nums[index] = -nums[index]
        
        # Find all indices with positive values (these are missing numbers)
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
        
        return result

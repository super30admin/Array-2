"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums) == 0:
            return []
        result = []
        # Changing index numbers to '-' once found
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * -1
        # Finding the numbers with discrepancy i.e the 
        # positive numbers and incrementing their index and return them
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
        return result
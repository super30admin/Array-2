# Time Complexity - O(N)

# Space Complexity - O(1)

# Did this code successfully run on Leetcode : No

# Any problem you faced while coding this : No

# Approach
# I use stqte change wherein I multiply the values by -1 whose index is abs(value) - 1.
# The answer is the indices of positive elements + 1

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums == None or len(nums) == 0:
            return []

        result = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if index < len(nums) and nums[index] > 0:
                nums[index] *= -1

        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)

        return result




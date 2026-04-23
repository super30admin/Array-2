# Time Complexity : O(N) N:length of array.
# Space complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Took sometime to reach O(1) space solution.

# Your code here along with comments explaining your approach
# Iterate through the array and use each number's value as an index, flipping the number at that index to negative.
# A positive number remaining at an index i means the value i + 1 was never appeared in the original list so return those.

class Solution:
    def findDisappearedNumbers(self, nums):
        result = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1

        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
        return result
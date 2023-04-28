## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Iterate over the array and mark the element at index nums[i] - 1 as negative. Iterate over the array again
# and append the index of the positive elements to the result array.

class Solution(object):
    def findDisappearedNumbers(self, nums):
        result = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = -nums[index]
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
        return result


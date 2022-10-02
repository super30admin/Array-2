# Time Complexity: O(1.5*n) -> comparisons reduced from O(2*n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No

import sys

class Solution(object):
    def minMaxComparisons(self, nums):
        """
        :type nums: List[int]
        """
        minElement = sys.maxsize
        maxElement = -sys.maxsize
        for i in range(len(nums)-1):
            if nums[i]>nums[i+1]:
                minElement = min(minElement, nums[i+1])
                maxElement = max(maxElement, nums[i])
            else:
                minElement = min(minElement, nums[i])
                maxElement = max(maxElement, nums[i+1])
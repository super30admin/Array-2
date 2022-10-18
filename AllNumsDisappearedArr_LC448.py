class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # Leetcode submission successful.
        # Time Complexity = O(n)
        # Space Complexity = O(1) as an array is expected to be returned. In-place edit.

        n = len(nums)
        for i in range(n):
            if nums[abs(nums[i]) - 1] > 0:
                nums[abs(nums[i]) - 1] = -nums[abs(nums[i]) - 1]
        out = []
        for j in range(n):
            if nums[j] > 0:
                out.append(j + 1)
        return out
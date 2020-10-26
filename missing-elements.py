# Time Complexity: O(n)
# Space Complexity: O(1)
# Did it run on Leetcode: Yes
# Approach:
# Use cyclic sort here - try place every element at index == element
# Once the array is cyclically sorted, re-iterate over the array
# - If the number and index don't match, the number/s represented by the index are missing.

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # Cyclic Sort
        i = 0
        n = len(nums)

        while i < n:
            j = nums[i] - 1
            if nums[i] != nums[j]:
                nums[i], nums[j] = nums[j], nums[i]  # swap
            else:
                i += 1

        missing = []

        for i in range(n):
            if nums[i] != i+1:
                missing.append(i+1)

        return missing

# Time Complexity: O(n) where n is the number of elements in array
# Space Complexity: O(1) if output array is not considered as extra space
# Ran on Leetcode: Yes

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        if not n:
            return []
        for elem in nums:
            nums[abs(elem) - 1] =abs(nums[abs(elem) - 1]) * -1
        return [i + 1 for i in range(n) if nums[i] > 0]
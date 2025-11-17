class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        Time Complexity: O(n)
        Space Complexity: O(n)
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        all_numbers = set(range(1, n + 1))
        present_numbers = set(nums)
        disappeared_numbers = list(all_numbers - present_numbers)
        return disappeared_numbers
class FindDisappearedNumbers(object):
    '''
    Solution:
    1. The optimal solution would be to store seen elements in a HashSet but instead of using a HashSet, we can modify
        the seen element as index and that index's sign to be turned to negative.
    2. Now, return those indices which didn't occur at all (by using index + 1 if index - 1 was used previously).
    3. Return the new list of missing elements.

    --- All testcases passed successfully on Leetcode.
    '''

    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # O(n) Time Complexity | O(1) Space Complexity
        if (nums == None or len(nums) == 0):
            return []

        for i in range(len(nums)):
            if nums[abs(nums[i]) - 1] > 0:
                nums[abs(nums[i]) - 1] *= -1

        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
        return result
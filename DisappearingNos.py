# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = []
        size = len(nums)
        # negate the numbers
        # since elements are from 1 to n
        # numbers are 1 to n. so a num - 1 => should be in ith position
        for i in range(size):
            position = abs(nums[i]) - 1
            if nums[position] > 0:
                nums[position] = nums[position] * -1

        #  if there are no negative integers in indices, then those numbers were missing

        for index in range(1, len(nums)+1):
            if nums[index-1] > 0:
                result.append(index)

        return result

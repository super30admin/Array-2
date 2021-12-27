# // Time Complexity : O(n)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : Yes

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        for num in nums:
            if nums[abs(num) - 1] > 0:
                nums[abs(num) - 1] = -1 * nums[abs(num) - 1]

        retArr = []
        for i in range(0, len(nums)):
            if nums[i] > 0:
                retArr.append(i + 1)

        return retArr
# Time Complexity : O(n) - n is length of nums
# Space Complexity : O(1) -
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Change the index corresponding to the number we find to a negative number.
Then again iterate over the array, to see at which indices, numbers > 0,
those indices are the missing numbers
"""

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = []
        n = len(nums)

        for i in range(0,n):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index]*-1

        for i in range(0,n):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] = nums[i]*-1

        return result
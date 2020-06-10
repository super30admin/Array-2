// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// multiply the index of the corresponding numbers with -1 to flag them as they are present. Return all the elements which are greater than 0

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []

        for i in range(len(nums)):

            ind = abs(nums[i]) - 1
            if (nums[ind] < 0):
                pass
            else:
                nums[ind] = nums[ind] * -1

        for i in range(len(nums)):

            if (nums[i] > 0):
                res.append(i+1)

        return res

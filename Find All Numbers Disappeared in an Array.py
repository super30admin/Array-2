""""// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def findDisappearedNumbers(self, nums):
        result = []
        if not nums:
            return result
        n = len(nums)
        for i in range(n):
            index = abs(nums[i]) - 1
            if (nums[index] > 0):
                nums[index] *= -1
        for i in range(n):
            if nums[i] > 0:
                result.append(i + 1)
            nums[i] *= -1
        return result


Obj=Solution()
print(Obj.findDisappearedNumbers([4,3,2,7,8,2,3,1]))

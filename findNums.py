# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class Solution(object):
    # for every number in the array, at the corresponding index multiply the number by -1, by doing
    # this we make sure that for all numbers in the array we mark their indexes as present and for the
    # second pass at every index where the number is > 0 add the corresponding number to the return array
    def findDisappearedNumbers(self, nums):
        retVal = []
        if not nums: return retVal
        for i in range(len(nums)):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] *= -1

        for idx, elem in enumerate(nums):
            if elem > 0:
                retVal.append(idx + 1)

        return retVal

print(Solution().findDisappearedNumbers([4,3,2,7,8,2,3,1]))

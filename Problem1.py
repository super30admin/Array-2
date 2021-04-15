## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

# Time complexity - O(n)
# Space complexity - O(1)


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return 0
        for i in nums:
            i=abs(i)
            nums[i-1] = -1*abs(nums[i-1])
        result = []
        for j in range(len(nums)):
            if nums[j]>0:
                result.append(j+1)
        return result
        
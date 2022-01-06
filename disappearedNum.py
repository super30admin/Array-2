# TC O(N)
# SC O(1)
# LEETCODE  YES
# PROBLEMS NO

from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(len(nums)):
            nums[abs(nums[i]) -1] = -abs(nums[abs(nums[i]) -1])
        
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return result

sol = Solution()
print(sol.findDisappearedNumbers([4,3,2,7,8,2,3,1]))
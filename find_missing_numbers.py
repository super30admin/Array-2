# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        sol = []
        _len = len(nums)
        for i in nums:
            _val = abs(i) - 1
            if nums[_val] > 0:
                nums[_val] *= -1
        for idx, i in enumerate(nums):
            if i > 0:
                sol.append(idx + 1)
        return sol


if __name__ == '__main__':
    _arr = [4, 3, 2, 7, 8, 2, 3, 1]
    print(Solution().findDisappearedNumbers(_arr))

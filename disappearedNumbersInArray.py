# Space Complexity:  O(1)
# TIme Complaxity : O(N)
from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        for idx, num in enumerate(nums):
            temp = abs(num)
            if nums[temp-1] > 0:
                nums[temp-1] = -1*nums[temp-1]
        
        for idx, num in enumerate(nums):
            if num < 0:
                nums[idx] = -1*nums[idx]
            else:
                res.append(idx+1)
        
        return res

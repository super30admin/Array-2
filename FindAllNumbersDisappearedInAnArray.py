'''
TC: O(n)
SC: O(1)
'''
from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        for v in nums:
            if nums[abs(v)-1] > 0:
                nums[abs(v)-1] = -nums[abs(v)-1]
        for i,v in enumerate(nums):
            if v > 0:
                res.append(i+1)
        return res
s = Solution()
print(s.findDisappearedNumbers([4,3,2,7,8,2,3,1]))
print(s.findDisappearedNumbers([1,1]))
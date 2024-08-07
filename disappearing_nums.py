# TIme complexity O(n)
# space O(1)
# tested on leetcode

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i,num in enumerate(nums):
            if nums[abs(num)-1] > 0:
                nums[abs(num)-1] *= -1
        for i,num in enumerate(nums):
            if num > 0:
                result.append(i+1)
        return result

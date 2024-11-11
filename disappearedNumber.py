"""
TC: O(n)  iterate through nums
SP:O(1) No additional space
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            n = abs(nums[i])
            if nums[n-1] > 0:
                nums[n-1] *=-1

        res = []
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)
        return res
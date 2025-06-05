"""
TC -> O(N)
SC -> O(1)
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        for i in range(len(nums)):
            index = abs(nums[i])-1
            if nums[index]>0:
                nums[index] = -1*nums[index]
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)
        return res
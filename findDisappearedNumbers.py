"""
TC:O(n)
SC:O(1)
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for idx in range(len(nums)) : 
            ele = abs(nums[idx]) - 1
            nums[ele] = abs(nums[ele]) * -1
            
        res = []
        
        for idx in range(len(nums)):
            if nums[idx] > 0:
                res.append(idx + 1)
            else :
                nums[idx] *= -1
        
        return res    
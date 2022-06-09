"""
TC: O(n)
SC: O(1)
"""
class Solution:
    def minMaxValue(self, nums: List[int]) -> int:
        def getMinMax( nums, n):
            min_val = nums[0]
            max_val = nums[0]
            
            for i in range(1,len(nums)) :
                if nums[i] < nums[i-1] :
                    min_val = min(min_val,nums[i])
                else:
                    max_val = max(max_val, nums[i])
                    
            return [min_val, max_val]
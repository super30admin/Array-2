# TC: O(N) where N is the size of the input array.
# SC: O(1) since we are not using any auxiliary space to perform operations.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums or len(nums) == 0:
            return 
        
        result = []
        for i in range(len(nums)):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] *= -1
        
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)
        
        return result

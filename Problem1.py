Time Complexity : O(n)
Space Complexity: O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return 1
        i = 0
        while i < len(nums):
            idx = abs(nums[i])-1
            if nums[idx]>=0:
                nums[idx] *= -1
            i += 1
        result = []
        for i in range(len(nums)):
            if nums[i] >=0:
                result.append(i+1)
        return result
        

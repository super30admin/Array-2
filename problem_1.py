# Time O(N)
# Space O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return nums 
        result = []
        for i, val in enumerate(nums):
            index = abs(val) - 1
            if nums[index] > 0:
                nums[index] *= -1 
        for i, val in enumerate(nums):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] *= 1
        return result
        
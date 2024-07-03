# Time Complexity : O(n)
# Space Complexity : O(1)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for num in nums:
            nums[abs(num) - 1] = (-1) * abs(nums[abs(num) - 1])
        return [i+1 for i in range(len(nums)) if nums[i] > 0]
        

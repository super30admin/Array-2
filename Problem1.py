# Time Complexity: O(N)
# Space Complexity: O(1)
# Passed Leetcode

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        out = []
        n = len(nums)
        for i in range(n):
            
            if nums[abs(nums[i]) - 1] > 0:
                nums[abs(nums[i]) - 1] *= -1
            
        for i in range(n):
            
            if nums[i] > 0:
                out.append(i + 1)
        return out
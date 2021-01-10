# Time Complexity: O(n)
# Space Complexity: O(1)
# Accepted on Leetcode
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        res = []
        for num in nums:
            if nums[abs(num)-1] > 0:
                
                nums[abs(num) - 1] *= -1
        
        for i,n in enumerate(nums):
            if n > 0:
                res.append(i+1)
        
        return res
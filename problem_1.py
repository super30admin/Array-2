# Problem: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/ 
# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums is None or len(nums) == 0:
            return []
        
        n = len(nums)
        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * -1
        
        res = []
        for i in range(n):
            if nums[i] > 0:
                res.append(i+1)
        
        return res
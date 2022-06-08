# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            if not nums[abs(nums[i])-1] < 0:
                nums[abs(nums[i])-1] *= -1
                
        res = []
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
        return res
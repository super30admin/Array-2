# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        for num in nums:
            ix = abs(num) - 1
            if nums[ix] > 0:
                nums[ix] = -1 * nums[ix]
        
        for ix, num in enumerate(nums):
            if num > 0:
                res.append(ix+1)
        return res
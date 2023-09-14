# Time Complexity: O(n) where n is the length of the matrix 
# Space Complexity:  O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in nums:
            index = abs(i)-1
            nums[index] = abs(nums[index]) * -1
        result = []
        for i,val in enumerate(nums):
            if val > 0:
                result.append(i+1)
        return result

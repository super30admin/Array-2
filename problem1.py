# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i in nums:
            if nums[abs(i)-1] > 0:
                nums[abs(i)-1] *= -1
                
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        
        return result
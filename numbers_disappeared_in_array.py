# Time Complexity : O(n) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No.

# Your code here along with comments explaining your approach:
# I go through the array changing the value-1 position of array to negative number. The index positions
# which do not have positive values + 1 are the numbers missing

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for num in nums:
            n = abs(num)
            if nums[n-1] > 0:
                nums[n-1] *= -1
        
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        
        return result
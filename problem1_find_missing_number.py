# https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/
# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        
        for num in nums:
            index = abs(num) - 1
            if nums[index] < 0:
                continue
            nums[index] = - nums[index]
  
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
                
        return result
                
        
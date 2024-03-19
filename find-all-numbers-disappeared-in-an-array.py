# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        
        for i in range(len(nums)):
            idx = abs(nums[i])-1
            if(nums[idx] > 0):
                nums[idx] *= -1
        
        for i in range(len(nums)):
            if(nums[i] > 0):
                result.append(i+1)
            else:
                nums[i] *= -1
        
        return result
            
sc = Solution()
nums = [4,3,2,7,8,2,3,1]
print(sc.findDisappearedNumbers(nums))
        
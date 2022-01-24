"""
Given an array nums of n integers where nums[i] is in the range [1, n], 
return an array of all the integers in the range [1, n] that do not appear in nums.

"""

# Time Complexity : O(n) linear
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No 

from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        map1 = {}
        result = []
        
        for i in nums:
            map1[i] = 1 
            
            
        for i in range(1, (len(nums) + 1)):
            
            if i not in map1:
                result.append(i)
                
        return result
        
s = Solution()
num = s.findDisappearedNumbers([1,2,3,4,7,8,9])
print(num)

                
            
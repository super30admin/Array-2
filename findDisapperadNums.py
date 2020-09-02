# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Done before the class
# Your code here along with comments explaining your approach
# Put the nums in a hashmap and then return the ones that are not in the hashmap from 1 to N

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        hashset = {}
        
        result = []
        
        for i in range(len(nums)):
            if nums[i] not in hashset.keys():
                hashset[nums[i]] = i
        
        for n in range(1, len(nums)+1):
            if n not in hashset.keys():
                result.append(n)
                
        return result
        
        
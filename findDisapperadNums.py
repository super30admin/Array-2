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
        
# ---Solution with O(1) space, discussed in class----#

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Discussed in class
# Your code here along with comments explaining your approach
# This involves manipulating the input array

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        if nums == None or len(nums)==0:
            return []
        
        result = []
        
        for i in range(len(nums)):
            #if the value at current index is non-negative, go to the index that equals its value
            index = abs(nums[i])-1
            if nums[index]>0:
                nums[index] *= -1
            

        # change the modified input array to have only negatives
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
                
        return result

        
# S30 FAANG Problem #31 {Easy}
# Find All Numbers Disappeared in an Array


# Time Complexity: O(n)
# Space Complexity: O(n) because of the extra array space we used
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach 1: add the list to the hashset, iterate over the numbers in the range and check if they're present in the set.
# If not, return the output list back.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        myset = set(nums)
        output = []
        
        for i in range(1, len(nums)+1):
            if i not in myset:
                output.append(i)
        
        return output

# Time Complexity: O(n) because the array is traversed once
# Space Complexity: O(1) because no extra space is used
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach 2: Mark the numbers corresponding to their indices as negative. In the end, all the indices with the positive numbers
# are the ones which need to be returned and are not found or missing in the array.
# This approach can be used only if the range of numbers is positive, that is 1.. n-1.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        output = []
        for idx, i in enumerate(nums):
            
            if nums[abs(i)-1] > 0:
                nums[abs(i)-1] = -(nums[abs(i)-1])
        
        for idx, i in enumerate(nums):
            
            if i > 0:
                output.append(idx+1)
                
        return output
    
    
    
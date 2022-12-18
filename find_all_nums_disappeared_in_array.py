""" 
Given an array nums of n integers where nums[i] is in the range [1, n], 
return an array of all the integers in the range [1, n] that do not appear in nums.

Time Complexity: O(n)
Space Complexity: O(1)
"""

def findDisappearedNumbers(nums):
    
    result = []
    
    for i in range(len(nums)):
        index = abs(nums[i]) - 
        
        if nums[index] > 0:
            nums[index] = -abs(nums[index])
        
    for i in range(len(nums)):
        if nums[i] > 0:
            result.append(i+1)
            
    return result
# 448. Find All Numbers Disappeared in an Array (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

# Approach: Approach to this solution is a little unique. 
# We will traverse through the array and negate the element on the index nums[i]-1. After the loop ends, elements that are still positive their value + 1 would be the result we are looking for

# Time complexity: O(n); n = number of elements in given array
# Space complexity: O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        if nums == None or len(nums) == 0:
            return []
        
        result = []
        n = len(nums)
        
        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1
                
        for i in range(n):
            if nums[i] > 0:
                result.append(i + 1)
                
        return result
            
            
        
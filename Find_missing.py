# Time Compelexity : O(n)
# Space Complexity: O(1)
# Approach to solve this problem:
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        missing = [] 
        
        for i in nums:
            pos = abs(i) - 1             
            if nums[pos] > 0:            # Everything is marked after this for loop
                nums[pos] *= -1                
        
        for i in range(len(nums)):       # What ever we find misssing we append
            if nums[i] > 0:
                missing.append(i+1)
                
        return missing
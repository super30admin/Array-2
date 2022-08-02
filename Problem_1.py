"""
Time Complexity : inside function
Space Complexity : inside function
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

 Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
"""
# Approach - 1: Sort the array, find the difference of the value and its index. TC:O(nlogn), SC:O(1)
# Approach - 2: use hash_map to store the occurenece of each number, return the ones with zero occuerence. TC:O(n), SC:O(n)
# Approach - 3: Temp state change of the values in the array. 

class Solution:
    def findDisappearedNumbers(self, nums):
        """
        Approach -2
        Time Complexity: O(n), n is no of elements in the list
        Space Complexity: O(n)
        """
        if len(nums) == 0: return 0
        
        res = []
            
        # creating the hash_map
        freq_map = {x:0 for x in range(0, len(nums))} 
        for num in nums:
            if (num-1) in freq_map:
                freq_map[num-1] += 1
       
            
        # checking for missing values
        for k,v in freq_map.items():
            if v == 0:
                res.append(k+1)
              
            
        return res


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        """
        Approach -3
        Time Complexity: O(n), n is no of elements in the list
        Space Complexity: O(1)
        """
        if len(nums) == 0: return 0
        
        res = []
        
        # First Pass: temp state change to negative number
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * -1
                
        # Second pass: check for positive numbers
        for i in range(len(nums)):
            if nums[i] > 0 :
                res.append(i + 1)
            else:
                nums[i] *= -1
              
            
        return res 
"""
Time Complexity : O(n), n is the number of elements in the list
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

 Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
"""
# Approach - 1: Sort the array, find the difference of the value and its index. TC:O(nlogn), SC:O(1)
# Approach - 2: use hash_map to store the occurenece of each number, return the ones with zero occuerence. TC:O(n), SC:O(n)
# Approach - 3: Temp state change of the values in the array. 

class Solution:
    def findDisappearedNumbers(self, nums):
        
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


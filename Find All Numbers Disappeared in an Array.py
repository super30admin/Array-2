# Tc: O(n)
# SC: O(n)
class Solution(object):
    def findDisappearedNumbers(self, nums):
        # Hash table for keeping track of the numbers in the array
       
        hash_table = {}
        
        # Add each of the numbers to the hash table
        for num in nums:
            hash_table[num] = 1
        
        # Response array that would contain the missing numbers
        result = []    
        
       
        for num in range(1, len(nums) + 1):
            if num not in hash_table:
                result.append(num)
                
        return result        

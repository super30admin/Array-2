#find min and max in an array
#if we compare each and every element with the min and max values, then its 2N comparison so instead of that take pairs, 
#there will be n//2 pairs and each pair will have 3 comparisons worse case so thats 1.5N comparisons.
#so think in pairs here
from typing import List

class Solution:
    def findMinandMax(self, nums: List[int]):

        if not nums:
             return [-1, -1]
        
        n = len(nums)

        max_val = float('-inf')
        min_val = float('inf')

        i = 0

        while i <= n-2:
                if nums[i] > nums[i+1]:
                    max_val = max(max_val, nums[i])
                    min_val = min(min_val, nums[i+1])
                else:
                    max_val = max(max_val, nums[i+1])
                    min_val = min(min_val, nums[i])
                
                i += 2
        
        if n % 2 != 0: #handle the last element if the length is odd and not even
             max_val = max(max_val, nums[-1])
             min_val = min(min_val, nums[-1])

        return [min_val, max_val]
    
# Time Complexity: O(N)
# Space Complexity: O(1)

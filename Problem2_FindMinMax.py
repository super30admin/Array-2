# Time Complexity : O(n) where n is the length of the array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Process elements in pairs, comparing within each pair first, then with min/max.
# This reduces comparisons to approximately 3n/2 instead of 2n by comparing pairs first.
# For each pair, compare elements to each other, then compare smaller to min and larger to max.

class Solution:
    def findMinMax(self, nums: List[int]) -> tuple:
        if not nums:
            return None, None
        
        n = len(nums)
        
        # Initialize min and max
        if n % 2 == 0:
            # Even number of elements: compare first two
            if nums[0] < nums[1]:
                min_val, max_val = nums[0], nums[1]
            else:
                min_val, max_val = nums[1], nums[0]
            start = 2
        else:
            # Odd number: first element is both min and max initially
            min_val = max_val = nums[0]
            start = 1
        
        # Process remaining elements in pairs
        for i in range(start, n, 2):
            if i + 1 < n:
                # Compare pair first
                if nums[i] < nums[i + 1]:
                    # nums[i] is smaller, nums[i+1] is larger
                    min_val = min(min_val, nums[i])
                    max_val = max(max_val, nums[i + 1])
                else:
                    # nums[i+1] is smaller, nums[i] is larger
                    min_val = min(min_val, nums[i + 1])
                    max_val = max(max_val, nums[i])
            else:
                # Last element if odd length
                min_val = min(min_val, nums[i])
                max_val = max(max_val, nums[i])
        
        return min_val, max_val

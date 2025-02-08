# Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparisons

# Time Complexity: O(n)
# Space Complexity: O(1)

# Approach:
# Use a single loop to find both the minimum and maximum.
# Compare the current element with the current minimum and maximum to update them accordingly.
# This approach ensures that we only need 1.5 * N comparisons, which is less than 2 * (N - 2).

# 2N comparisons 
class Solution:
    def findMinMax(self, nums: List[int]) -> Tuple[int, int]:
        if not nums:
            return None, None   
        
        min_val = float('inf')
        max_val = float('-inf')
        
        for num in nums:
            if num < min_val:
                min_val = num
            if num > max_val:
                max_val = num
                
        return min_val, max_val
        
# 1.5N comparisons 
class Solution:
    def findMinMax(self, nums: List[int]) -> Tuple[int, int]:
        if not nums:
            return None, None   
        
        starting_index = None
        if len(nums) % 2 == 0:
            min_val = min(nums[0], nums[1])
            max_val = max(nums[0], nums[1])
            starting_index = 2
        else:
            min_val = nums[0]
            max_val = nums[0]
            starting_index = 1
        
        # Compare pairs of elements and step by 2
        for i in range(starting_index, len(nums), 2):
            if nums[i] < nums[i+1]:
                min_val = min(min_val, nums[i])
                max_val = max(max_val, nums[i+1])
            else:
                min_val = min(min_val, nums[i+1])
                max_val = max(max_val, nums[i])

        return (min_val, max_val)


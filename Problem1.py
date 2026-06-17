## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

# Time Complexity: O(N) where N is the length of the input array. 
#                  We iterate through the array twice, doing constant time operations.
# Space Complexity: O(1) auxiliary space. We modify the input array in-place to track 
#                   visited numbers. (The result array does not count towards auxiliary space).

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        
        # First pass: mark the numbers we have seen.
        for n in nums:
            # Since numbers are 1 to N, we subtract 1 to map the number to a valid 0-based index.
            # We use abs(n) because the value might have already been turned negative 
            # by a previous step in the loop.
            idx = abs(n) - 1
            
            # If the value at this target index is still positive, we make it negative.
            # A negative value at index 'idx' acts as a flag indicating that the number 
            # 'idx + 1' exists in the array.
            if nums[idx] > 0:
                nums[idx] *= -1
                
        # Second pass: find the missing numbers and restore the original array.
        for i, n in enumerate(nums):
            # If the value is negative, it means the number (i + 1) was present in the array.
            # We restore the array's original state by turning it back to positive.
            if n < 0:
                nums[i] *= -1
            # If the value is positive, it means we never encountered the number (i + 1)
            # during our first pass. Thus, it's a disappeared number.
            else:
                result.append(i + 1)
                
        return result
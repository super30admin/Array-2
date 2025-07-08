# Time Complexity: O(n)
# Space Complexity: O(1)
# Were you able to run the code on Leetcode: No
# Any problem you faced while coding this: No

from typing import List, Tuple
class Solution:
    def findMinMax(self, nums: List[int]) -> Tuple[int, int]:
        if not nums:
            return (0, 0)
        
        if len(nums) == 1:
            return (nums[0], nums[0])

        min_val = nums[0]
        max_val = nums[1]

        for i in range(1, len(nums)):
            # if current element is less than previous element
            # check min of current element and previous min
            # check max of previous element and previous max
            if nums[i] < nums[i-1]:
                min_val = min(min_val , nums[i])
                max_val = max(max_val, nums[i-1])
            # if current element is greater than previous element
            # check min of previous element and previous min
            # check max of current element and previous max
            elif nums[i] > nums[i-1]:
                min_val = min(min_val, nums[i-1])
                max_val = max(max_val, nums[i])
            
        # Handle the last element
        min_val = min(min_val, nums[-1])
        max_val = max(max_val, nums[-1])
                  

        return (min_val, max_val)
    

# Example usage:
if __name__ == "__main__":
    nums = [3, 5, 1, 2, 4]
    solution = Solution()
    min_val, max_val = solution.findMinMax(nums)
    print(f"Minimum value: {min_val}, Maximum value: {max_val}")  # Output: Minimum value: 1, Maximum value: 5
    
    nums = [ 7, 2, 8, -10, 6]
    min_val, max_val = solution.findMinMax(nums)
    print(f"Minimum value: {min_val}, Maximum value: {max_val}")  # Output: Minimum value: -10, Maximum value: 8
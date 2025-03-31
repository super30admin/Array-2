'''
Mark each visited index by negating the value at the corresponding index (abs(num) - 1).
After marking, the indices with positive values indicate the numbers that did not appear in the array.
Collect those indices + 1 to get the missing numbers.

Time Complexity:O(n)
Space Complexity: O(1)
'''

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for num in nums:
            index = abs(num) - 1
            nums[index] = -abs(nums[index])
        
        return [i + 1 for i, num in enumerate(nums) if num > 0]

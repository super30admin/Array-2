# 448. Find All Numbers Disappeared in an Array

# Time Complexity: O(n)
# Space Complexity: O(1)

# Approach:
# Use the input array to mark the presence of numbers.
# Iterate through the array and for each element, mark the presence of the number by negating the value at the index equal to the absolute value of the current element minus 1.
# Iterate through the array again and collect the indices of the positive values, which represent the missing numbers.

# without extra space and in O(n) runtime
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1
                
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
                
        return result
            
# Approach 1 - Maintain a set with all the numbers in range, run a for loop, start removing all the
# numbers from set which exists in nums arr, return the set with remaining numbers
# Time complexity - O(n)
# Space complexity - O(n)

# from typing import List
# class Solution:
#     def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
#         Set = set(range(1, len(nums)+1))

#         for i in range(len(nums)):
#             if nums[i] in Set:
#                 Set.remove(nums[i])
        
#         return list(Set)

# Approach 2 - Run first loop to negate all the numbers that you see in nums arr, run second
# loop to look for numbers that were not negated and append it to result
# Time complexity - O(n)
# Space complexity - O(1)

from typing import List
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Called temperory state change pattern
        result = []
        for i in range(len(nums)):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] = - nums[idx]
        
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] = -nums[i]
        
        return result
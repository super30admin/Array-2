# Time Complexity: O(N), N is the number of elements in nums
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes


from typing import List

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for index in range(len(nums)):
            updated_index = abs(nums[index]) - 1

            if nums[updated_index] > 0:
                nums[updated_index] = - nums[updated_index]
            
        result = []

        for number in range(1, len(nums) + 1):
            if nums[number - 1] > 0:
                result.append(number)
            else:
                nums[number - 1] = abs(nums[number - 1])
        
        return result
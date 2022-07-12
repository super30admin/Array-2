'''

## Problem 448: Find all numbers disappeared in an array.

## Author: Neha Doiphode
## Date:   07-10-2022

## Description
Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.

## Examples:
    Example 1:
        Input: nums = [4,3,2,7,8,2,3,1]
        Output: [5,6]

    Example 2:
        Input: nums = [1,1]
        Output: [2]

## Constraints:
    n == nums.length
    1 <= n <= 105
    1 <= nums[i] <= n

## Time complexity: O(n), we are iterating over the array twice, one after the other.

## Space complexity: O(1), no auxiliary space is used. Space to store the result is not counted.

'''
from typing import List

def get_input():
    print("Enter the array of integers(with spaces): ", end = "")
    inp_list = input()
    inp_list = [int(value) for value in inp_list.split()]
    return inp_list


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums) <= 0:
            return []

        result = []
        for num in nums:
            index = abs(num) - 1

            if nums[index] > 0:
                nums[index] *= -1


        for index, num in enumerate(nums):
            if num > 0:
                result.append(index + 1)
        return result

# Driver code
solution = Solution()
inp_array = get_input()
print(f"Input array: {inp_array}")
print(f"Numbers disappeared in input array: {solution.findDisappearedNumbers(inp_array)}")

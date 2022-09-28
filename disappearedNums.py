"""
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range
[1, n] that do not appear in nums.
TC - O(n)
SC - O(n) - since new array is created
"""

n = [4, 3, 2, 7, 8, 2, 3, 1]


def findDisappearedNumbers(nums):
    nums_set = set(nums)
    original_set = set(i for i in range(1, len(nums)+1))

    rtnData = list(original_set - nums_set)

    return list(rtnData)


print(findDisappearedNumbers(n))


"""
448. Find All Numbers Disappeared in an Array
Easy
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 
Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:
Input: nums = [1,1]
Output: [2]

 
Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n

 
Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

"""

class Solution:
    """
    Accepted
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Intuition:
    - The problem is to find all the numbers that do not appear in the list. 
    - The key observation is that all elements are between 1 and n (where n is the size of the list), and each number can be mapped to an index in the list.
    - By traversing the list and marking the index that each number maps to, we can find out which numbers do not appear.

    Approach:
    - Iterate over the list, mark the index corresponding to each number as negative.
    - In the second iteration, find the positive numbers, their indices are the disappeared numbers.
    """
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for idx, i in enumerate(nums):
            jdx = abs(i) - 1
            if jdx < len(nums) and nums[jdx] > 0:
                nums[jdx] = nums[jdx] * -1
        res = []
        for idx,i in enumerate(nums):
            if i > 0:
                res.append(idx+1)
        return res

LeetCode(PROBLEM, Solution).check()

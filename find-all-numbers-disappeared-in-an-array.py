"""

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:

Input: nums = [1,1]
Output: [2]

Time Complexity : O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# This approach marks the presence of numbers in the given list by negating the values at their corresponding indices.  
# After processing, the indices with positive values indicate the missing numbers since they were never marked negative.  
# Finally, collected and return these missing numbers by checking which indices remain positive.  


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        for i, num in enumerate(nums):

            new_i = abs(num) - 1

            if nums[new_i] > 0:
                nums[new_i] *= -1

        res = []

        for i in range(1, len(nums) + 1):
            if nums[i-1] > 0:
                res.append(i)

        return res

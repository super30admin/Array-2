"""
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the
integers in the range [1, n] that do not appear in nums.

Approach1: search for each number in the range 1 to n and if not present add to result.
Time complexity: O(n^2)

Approach2:  since we are searching for a number in array, the nested loop can be replaced with the hash set.
Save the number in the array and then check if numbers from 1 to n is present in the hash set.
Time complexity: O(n) + O(n) and space complexity: O(n)

Approach3: take an boolean array of length 1 to n and initialize with False and traverse the given array
and mark the number present as True. At the end, traverse the boolean array and find what all numbers are marked
as False.
Time  complexity: O(n) and space complexity: O(n)

Approach 4: sort and iterate over the array. Skip the duplicates and if the iterator idx is > number in the array,
that means the number is not present in the array.
Time complexity: nlog(n) + O(n)

Approach 5: sort and binary search to find the number.
time complexity: nlog(n) + nlog(n)

Approach 6: To save space and keep time complexity: O(n), we can record the presence of the number in the original array
itself. For example, if I want to mark the 4 is present in the array, mark the 3rd index as -1 * number[3].
there could be duplicates so before updating check if it is already negative. And when checking the number, take
the absolute value of the number. During the second pass to check what all numbers are missing, update the values to
positive.

Note: If there are negative numbers in the array, you can take offset, for example, -10 to -20, make it -10+21 to -20+21
like add 21 to all the numbers. After identifying missing numbers subtract 21.

Time complexity: 2* O(n) and space complexity: O(1).

To do: implement approach 4
"""
from typing import List


class Solution:
    def findDisappearedNumbers_hset(self, nums: List[int]) -> List[int]:

        hset = set()
        ans = []
        for num in nums:
            hset.add(num)

        for i in range(1, len(nums) + 1):
            if i not in hset:
                ans.append(i)

        return ans

    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        ans = []
        for num in nums:
            idx = abs(num) - 1
            if nums[idx] > 0:
                nums[idx] = -1 * nums[idx]

        for idx, num in enumerate(nums):
            if num > 0:
                ans.append(idx + 1)

        return ans



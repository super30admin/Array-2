"""
Leetcode - https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/ (submitted)
TC- , SC-
Lecture- https://youtu.be/gfbrKPooo2w
FAQ-
Using extra space? Use hashmap and look for 1:N exists if not add it to your answer array
Without using extra space? Idea is to keep track of visited elements in the array itself by multiplying it by -1
(since all numbers are greater than one, this will be our identifier for visited) for every unique element.
Then iterate and check for positive numbers which will be your missing numbers in the same array.
Other techniques? You can also use sorting and do a search from 1:N for missing element

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the
range [1, n] that do not appear in nums.

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

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count
as extra space.
"""


class Solution:
    # Idea - refer FAQ in top
    # TC- O(2N), SC- O(1)
    def findDisappearedNumbers(self, nums):
        missingList = []
        n = len(nums)
        for i in range(n):
            # lookup for the current value in it's index
            goToIndex = abs(nums[i]) - 1
            #  if go to index in range and it's the element inside is positive
            if goToIndex < n and nums[goToIndex] > 0:
                nums[goToIndex] *= -1

        for i in range(n):
            if nums[i] > 0:
                # i + 1 is our desired value for that index
                missingList.append(i + 1)
            else:
                # Flip negatives for it's original value if interviewer asked.
                nums[i] *= -1

        return missingList

    # TC - O(2N), SC- O(N) solution
    def findDisappearedNumbers1(self, nums):
        map_ = {}
        missingList = []

        # storing elements in the list in hashmap
        for ele in nums:
            if ele not in map_:
                map_[ele] = 0
        # iterating desired 1:N and finding missing elements
        for i in range(1, len(nums) + 1):
            if i not in map_:
                missingList.append(i)

        return missingList


arr = [4, 3, 2, 7, 8, 2, 3, 1]
missingElements = Solution().findDisappearedNumbers(arr)
print(missingElements)

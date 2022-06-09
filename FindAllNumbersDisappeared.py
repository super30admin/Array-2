#448. Find All Numbers Disappeared in an Array
"""
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

We are keeping Space Complexity = O(1) so no auxilary datatypes are used.
To change in array itself, We parse through array element by element, of element
we change element2 to negative (provided that element2's location or index = element -1)
So, in the end element which are positive, those element's index number are missing elements forom the main array.
"""


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums) == 0:
            return []

        result = list()
        # parsing list element by element
        for i in range(0, len(nums)):
            temp = abs(nums[i])  # checking absolute value in case if it is already negative
            # If that element is =ve, we change its index to -ve
            if nums[temp - 1] > 0:
                nums[temp - 1] = nums[temp - 1] * -1

        # loop to find =ve element so that we can return its index no as answer
        for i in range(0, len(nums)):
            if nums[i] > 0:
                result.append(i + 1)

        # print(result)
        return result
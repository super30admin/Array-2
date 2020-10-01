"""
Problem: 448. Find All Numbers Disappeared in an Array
Leetcode: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
Time Complexity: O(n), n is the number of elements in given array
Space Complexity: O(1), since we only use output array to return the values
"""


class Solution:
    def find_disappeared_numbers(self, nums):

        output = []
        # Base case
        if nums is None or len(nums) is 0:
            return output

        # Traverse the given array
        for num in nums:
            # find index
            idx = abs(num) - 1
            # if positive number exists, convert it to a negative number
            if nums[idx] > 0:
                nums[idx] = -nums[idx]

        # if positive number exists here i.e. it was not present in given array, add it to the output array
        for i in range(len(nums)):
            if nums[i] > 0:
                output.append(i+1)

        return output


obj = Solution()
print(obj.find_disappeared_numbers([4,3,2,7,8,2,3,1]))
print(obj.find_disappeared_numbers([1,1,1,1,1,1,1]))
print(obj.find_disappeared_numbers([]))

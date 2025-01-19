#  Problem: Given an array of numbers of length N, find both the minimum and maximum. 
#            Follow up : Can you do it using less than 2 * (N - 2) comparison
#  Time Complexity: O(n)
#  Space Complexity: O(1)
#  Did this code successfully run on Leetcode : Couldn't find this problem on Leetcode. Solved this:
#  https://leetcode.com/problems/removing-minimum-and-maximum-from-array/ , this is a similar problem.

class Solution:
    def minimum_maximum(self, nums: list[int]) -> (int, int):       
        n = len(nums)
        if n == 0:
            return None, None
        if n == 1:
            return nums[0], nums[0]

        if nums[0] < nums[1]:
            minimum, maximum = nums[0], nums[1]
        else:
            minimum, maximum = nums[1], nums[0]

        for i in range(2, n - 1, 2):
            if nums[i] < nums[i + 1]:
                minimum = min(minimum, nums[i])
                maximum = max(maximum, nums[i + 1])
            else:
                minimum = min(minimum, nums[i + 1])
                maximum = max(maximum, nums[i])

        # If odd number of elements, compare the last one
        if n % 2 == 1:
            minimum = min(minimum, nums[n-1])
            maximum = max(maximum, nums[n-1])

        return minimum, maximum
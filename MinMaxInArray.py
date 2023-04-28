## Problem2
# Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison


# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Compare the elements in pairs. If the number of elements is odd, initialize min and max with the first element.

def minMax(nums):
    if not nums:
        return None
    if len(nums) == 1:
        return nums[0], nums[0]
    if nums[0] < nums[1]:
        min = nums[0]
        max = nums[1]
    else:
        min = nums[1]
        max = nums[0]
    for i in range(2, len(nums) - 1, 2):
        if nums[i] < nums[i + 1]:
            if nums[i] < min:
                min = nums[i]
            if nums[i + 1] > max:
                max = nums[i + 1]
        else:
            if nums[i + 1] < min:
                min = nums[i + 1]
            if nums[i] > max:
                max = nums[i]
    if len(nums) % 2 != 0:
        if nums[-1] < min:
            min = nums[-1]
        elif nums[-1] > max:
            max = nums[-1]
    return min, max
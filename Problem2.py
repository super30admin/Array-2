## Problem2
# Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
# Time Complexity - O(n)
# Space Complexity - O(1) - will always have only a pair

class min_max:
    def __init__(self):
        self.min = 0
        self.max = 0

def solution(nums):
    if not nums:
        return 0
    
    if len(nums) == 1:
        return nums[0], nums[0]
    
    minmax = min_max()

    if(nums[0]>nums[1]):
        minmax.min = nums[1]
        minmax.max = nums[0]
    else:
        minmax.min = nums[0]
        minmax.max = nums[1]

    for i in range(2,len(nums)):
        if nums[i] < minmax.min:
            minmax.min = nums[i]
        elif nums[i] > minmax.max:
            minmax.max = nums[i]

    return minmax.min, minmax.max




nums = [2301,87,12,11023,1,435]
minimum, maximum = solution(nums)
print("minimum = ", minimum)
print("maximum = ", maximum)

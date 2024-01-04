'''
Time complexity: O(n)
Space complexity: O(1) because the result calculated on the array itself and stored in two variables.
'''

import math

def MinMax_lesscompare(nums:list[int]):

    minL = math.inf
    maxL = nums[0]
    for i in range(len(nums)-1):
        if (nums[i]<nums[i+1]):
            minL = min(nums[i], minL)
            maxL = max(maxL, nums[i+1])

    return [minL,maxL]

arr = [-4, 5, 8, 1, 3, 0, 9, 2, 11, -10, 100]
print(MinMax_lesscompare(arr))
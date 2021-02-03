# // Time Complexity : O(3*n/2 + 2)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
# // Your code here along with comments explaining your approach:
# Iterate through the array, and compare every pair of elements. Find lesser and greater from the pair, and compare lesser with minimum,
# and greater with maximum. At last, if the array length is even, return the maximum, and minimum found. Else, compare last element of array
# with maximum and minimum element, and return the updated maximum and minimum.

def compare(a, b):
    if a > b:
        greater = a
        lesser = b
    else:
        greater = b
        lesser = a
    return lesser, greater

def find_min_max(nums):

    if len(nums) == 0:
        return None

    minimum = 100000000
    maximum = -100000000

    for i in range(0, len(nums)-1, 2):

        lesser, greater = compare(nums[i], nums[i+1])

        minimum, _ = compare(lesser, minimum)
        _, maximum = compare(greater, maximum)

    if len(nums)//2 != 0:
        minimum, _ = compare(nums[-1], minimum)
        _, maximum = compare(nums[-1], maximum)

    return minimum, maximum




print(find_min_max([5, 10, 24, 0, 1, 9]))

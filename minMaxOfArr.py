"""
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
"""

# Approach 1 : Linear search - O(N) - N comparisons

import math

def minMax(nums):
    mi, ma = math.inf, -math.inf
    for n in nums:
        ma = max(n,ma)
        mi = min(n,mi)
    return mi,ma

nums =  [2,2,4,5,6,7,3,2,1]
print(minMax(nums))

# Approach 2: compare in pairs - total 3n/2 comparisons  ~= 1.5n
# we can do so because in any given pair of numbers we find out which one is big and small
# Then use big number to compare with current max and small with current min,
# this means we don't have to compare every single number with min and max like we did above.

def minMaxBetter(nums):
    mi, ma = math.inf, -math.inf
    i = 0
    while i+1 < len(nums): # we compare two numbers at a time
        print(i)
        if nums[i] > nums[i+1]:   # We do 1 comparison here
            mi = min(mi, nums[i+1]) # and depending on which branch of if/else we go in
            ma = max(ma, nums[i]) # we do 2 comparisons
        else:
            mi = min(mi, nums[i])
            ma = max(ma, nums[i+1])
        i+=1
    return mi,ma

nums =  [2,2,4,5,6,7,3,2,1,0]
print(minMaxBetter(nums))

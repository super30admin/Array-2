# https://www.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1

## Problem2
# Given an array of numbers of length N, find both the minimum and maximum. 
# Follow up : Can you do it using less than 2 * (N - 2) comparison


# Time Complexity : O(n/2) = O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here when we run a loop linearly to calculate the max and min, the number of comparisons is 2*n. But when we take a pair of two
# elements, and compare them to get the max and min, the number of comparisons reduces by 1 for each pair. So total number of comparisons
# would be (3*(n // 2)) + 2 for odd number of elements. However the time complexity remains O(n)

class Solution:
    def get_min_max(self, arr):
        minn = arr[0]
        maxx = arr[0]
        i = 0
        
        # for each pair of 2 elements
        # number of comparisons = 3
        # so total comparisons reduced = 3 * (n // 2) + 2 in worst case
        for i in range(1, len(arr), 2):
            if(arr[i] > arr[i - 1]):
                # check for arr[i] being max
                # check for arr[i - 1] being min
                maxx = max(maxx, arr[i])
                minn = min(minn, arr[i - 1])
            else:
                # check for arr[i] being min
                # check for arr[i - 1] being max
                maxx = max(maxx, arr[i - 1])
                minn = min(minn, arr[i])
                
        # if len(arr) was odd we would have to compare the last element
        # Note: i = last index if len(arr) = even. i = last index - 1 if len(arr) = odd
        i += 1
        if(i == len(arr) - 1):
            # we have odd no. of elements
            maxx = max(maxx, arr[i])
            minn = min(minn, arr[i])
        
        return [minn, maxx]

sol = Solution()
print(sol.get_min_max([3, 2, 1, 56, 10000, 167]))
print(sol.get_min_max([1, 345, 234, 21, 56789]))
print(sol.get_min_max([56789]))

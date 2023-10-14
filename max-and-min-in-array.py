# Given an array of size N. The task is to find the maximum and the minimum element of the array using the minimum number of comparisons.
class Solution(object):

    # Solution 1
    # Brute Force
    # TC: 2O(n) where n is the length of array
    # At every element, 2 comparisons i.e 1 for min and 1 for max
    # SC: O(1)

    # def FindMaxAndMin(self, arr):
    #     maxVal = float('-inf')
    #     minVal = float('inf')

    #     for i in range(len(arr)):
    #         minVal = min(minVal, arr[i])
    #         maxVal = max(maxVal, arr[i])

    #     return minVal, maxVal

    # Considering a pair for comparison. If arr is odd numbered, we set min,max as first element and do pair comparison for the rest. If not, then we set min and max as positive and negative infinity respectively and do pair comparison from first element itself.

    # Solution 2:
    # sort the array and first element of array = min value and last would be max.
    # TC: nlogn
    # SC: O(n)

    # Solution 3: pair comparison
    def FindMaxAndMin(self, arr):
        n = len(arr)
        end = n-1
        # 1 comparison i.e. O(1)
        if n % 2 == 0:  # even numbered  array
            start = 0
            maxVal = float('-inf')
            minVal = float('inf')
        else:  # odd numbered array
            start = 1
            maxVal = arr[0]
            minVal = arr[0]

        # 3 comparisons per pair. i.e. 3/2(n) = 1.5 O(n) which is > 2 O(n) in brute force
        for i in range(start, end, 2):
            if arr[i] > arr[i+1]:  # 1 comparison
                maxVal = max(maxVal, arr[i])  # 1 comparison
                minVal = min(minVal, arr[i+1])  # 1 comparison
            else:
                maxVal = max(maxVal, arr[i+1])
                minVal = min(minVal, arr[i])

        return minVal, maxVal


obj = Solution()
print(obj.FindMaxAndMin(
    [-10, 10, 1000000, 1000, -3, -33, 1000, 2, 8, 10034748738]))

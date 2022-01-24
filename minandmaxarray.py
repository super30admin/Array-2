"""
Given an array of numbers of length N, find both the minimum and maximum. 
Follow up : Can you do it using less than 2 * (N - 2) comparison

https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
"""

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on geeksforgeeks : Yes
# Any problem you faced while coding this : No 


from typing import List

def getMinMax(low, high, arr):

    # initializing 2 arrays and setting them to same pointer low
    maxArray = arr[low]
    minArray = arr[low]
     
    # base
    # if there is only 1 element, same element is high/low and return same
    if low == high:
        maxArray = arr[low]
        minArray = arr[low]
        return (maxArray, minArray)
         
    # If 2 elements, find which one is bigger and return accordingly
    elif high == low + 1:
        if arr[low] > arr[high]:
            maxArray = arr[low]
            minArray = arr[high]
        else:
            maxArray = arr[high]
            minArray = arr[low]
        return (maxArray, minArray)

    # if more than 2 elements
    else:
         
        # Use binary search type division to mid. 
        # Perform recursive appraoch to right and left parts to find min/max
        mid = int((low + high) / 2)
        maxArray1, minArray1 = getMinMax(low, mid, arr)
        maxArray2, minArray2 = getMinMax(mid + 1, high, arr)
 
    # return min or max on whichever is smaller or bigger
    return (max(arr_max1, arr_max2), min(arr_min1, arr_min2))




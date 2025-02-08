# Problem 2 -  
'''
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) 
comparison
'''
# Time Complexity : 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
The challenge I faced in this problem was coming up with the idea of comparing pairs of elements to store the minimum and 
maximum values, rather than comparing each individual element, in order to reduce the number of comparisons.
'''

# Your code here along with comments explaining your approach
def find_min_max(arr):
    length = len(arr)
    # if the array is empty then return 0, 0
    if length == 0:
        return 0, 0
    # if the length of the array is 1 then return the one element
    if length == 1:
        return arr[0], arr[0]
    
    # Will compare first two element and will save minimum element in minVal and maximum element in maxVal
    if arr [0] > arr[1]:
        maxVal = arr[0]
        minVal = arr[1]
    else:
        maxVal = arr[1]
        minVal = arr[0]
    # Will loop from 3rd element and will compare elements in pair to reduce number of comparison 
    for i in range(2, len(arr)-1, 2):
        # compare the elements in pair and store the maximum element in maxVal and minimum element in minVal
        if arr[i] > arr[i+1]:
            minVal = min(minVal, arr[i+1])
            maxVal = max(maxVal, arr[i])
        else:
            minVal = min(minVal, arr[i])
            maxVal = max(maxVal, arr[i+1])
    # if the length of array is odd then we will compare the last element with minVal and maxVal to store the minimum and maximum value
    if length % 2 != 0:
        minVal = min(minVal, arr[length-1])
        maxVal = max(maxVal, arr[length-1])
    return minVal, maxVal


arr = [21, 24, 23, 25, 26]
min_val, max_val = find_min_max(arr)
print("Minimum:", min_val)  # Output: Minimum: 21
print("Maximum:", max_val)  # Output: Maximum: 26
"""
Maximum and minimum of an array using minimum number of comparisons
https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
"""

def getMinMax(arr: list) : 
# Set Min and Max in pairs.
# Run Time Complexity : 3*(n-1)/2
# Space Complexity : O(1)
    n = len(arr)
    min = 0
    max = 0
    if n == 1: 
        max = arr[0] 
        min = arr[0] 
        return minmax 
  
    if arr[0] > arr[1]: 
        max = arr[0] 
        min = arr[1] 
    else: 
        max = arr[1] 
        min = arr[0] 
  
    for i in range(2, n): 
        if arr[i] > max: 
            max = arr[i] 
        elif arr[i] < min: 
            min = arr[i] 
  
    return min, max

arr = [1000, 11, 445, 1, 330, 3000] 
print(getMinMax(arr))
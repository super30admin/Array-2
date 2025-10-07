# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Approach :
# 1. Compare elements in pairs, reducing comparisons by half.
# 2. First compare the two elements to decide smaller/larger.
# 3. Update global min and max accordingly.

def getMinMax(arr):
    n = len(arr)
    
    # If array has even number of elements
    if n % 2 == 0:
        if arr[0] < arr[1]:
            mn, mx = arr[0], arr[1]
        else:
            mn, mx = arr[1], arr[0]
        i = 2
    else:
        # If odd, initialize with first element
        mn = mx = arr[0]
        i = 1
    
    # Process pairs
    while i < n - 1:
        if arr[i] < arr[i+1]:
            mn = min(mn, arr[i])
            mx = max(mx, arr[i+1])
        else:
            mn = min(mn, arr[i+1])
            mx = max(mx, arr[i])
        i += 2
    
    return mn, mx

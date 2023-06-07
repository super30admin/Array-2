# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

def getMinMax(arr):
    n = len(arr)
    if((n % 2) == 0):
        maxarr = max(arr[0], arr[1])
        minarr = min(arr[0], arr[1])
        i = 2
    else:
        maxarr = minarr = arr[0]
        i = 1
    while(i < (n - 1)):
        if arr[i] < arr[i + 1]:
            maxarr = max(maxarr, arr[i + 1])
            minarr = min(minarr, arr[i])
        else:
            maxarr = max(maxarr, arr[i])
            minarr = min(minarr, arr[i + 1])
        i += 2
    return (maxarr, minarr)
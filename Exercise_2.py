    # Time Complexity : O(n)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

def getMinMax(arr):

    if len(arr) % 2 == 0:
        max_value = max(arr[0], arr[1])
        min_value = min(arr[0], arr[1])
        i = 2
    else:
        max_value = arr[0]
        min_value = arr[0]
        i = 1

    while(i < len(arr) - 1):
        if arr[i] < arr[i + 1]:
            max_value = max(max_value, arr[i + 1])
            min_value = min(min_value, arr[i])
        else:
            max_value = max(max_value, arr[i])
            min_value = min(min_value, arr[i + 1])

        i += 2
     
    return (max_value, min_value)
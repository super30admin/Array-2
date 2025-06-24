# Time Complexity : O(n\N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No source link provided.
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

# Compare elements in pairs because we need to reduce comparisions.
#  For each pair, first compare the 2 elements to identify the smaller and larger.
# Then compare the smaller to the current_min and the larger to the current_max. 


def find_min_and_max(arr):
    n = len(arr)
    
    if n == 0:
        return None, None
    if n == 1:
        return arr[0], arr[0]

    # Initialize min and max
    if n % 2 == 0:
        if arr[0] < arr[1]:
            current_min = arr[0]
            current_max = arr[1]
        else:
            current_min = arr[1]
            current_max = arr[0]
        i = 2
    else:
        current_min = current_max = arr[0]
        i = 1

    # Compare elements in pairs
    while i < n - 1:
        if arr[i] < arr[i + 1]:
            small = arr[i]
            large = arr[i + 1]
        else:
            small = arr[i + 1]
            large = arr[i]
        
        if small < current_min:
            current_min = small
        if large > current_max:
            current_max = large

        i += 2

    return current_min, current_max
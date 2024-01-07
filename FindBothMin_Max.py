#time: O(n)
#space: O(1)

def find_min_max(arr):
    n = len(arr)

    # Initialize min and max with the first element
    min_val, max_val = arr[0], arr[0]

    # Iterate through the array with a step of 2
    for i in range(1, n - 1, 2):
        if arr[i] < arr[i + 1]:
            # Compare and update min and max in pairs
            min_val = min(min_val, arr[i])
            max_val = max(max_val, arr[i + 1])
        else:
            min_val = min(min_val, arr[i + 1])
            max_val = max(max_val, arr[i])

    # Handle the last element if the array length is odd
    if n % 2 == 0:
        min_val = min(min_val, arr[-1])
        max_val = max(max_val, arr[-1])

    return min_val, max_val

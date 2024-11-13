"Time Complexity is O(N)"
def find_min_max(arr):
    if not arr:
        return None, None

    n = len(arr)

    # Initialize min and max
    if n % 2 == 0:
        min_val = min(arr[0], arr[1])
        max_val = max(arr[0], arr[1])
        i = 2
    else:
        min_val = max_val = arr[0]
        i = 1

    # Iterate over pairs
    while i < n - 1:
        if arr[i] < arr[i + 1]:
            min_val = min(min_val, arr[i])
            max_val = max(max_val, arr[i + 1])
        else:
            min_val = min(min_val, arr[i + 1])
            max_val = max(max_val, arr[i])
        i += 2

    return min_val, max_val

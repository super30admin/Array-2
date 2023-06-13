def findMinMax(arr):
    n = len(arr)

    # Initialize min_val and max_val with the first two elements
    if arr[0] < arr[1]:
        min_val = arr[0]
        max_val = arr[1]
    else:
        min_val = arr[1]
        max_val = arr[0]

    # Iterate through the array, comparing elements pairwise
    i = 2  # Start from the third element
    while i < n - 1:
        if arr[i] < arr[i + 1]:
            if arr[i] < min_val:
                min_val = arr[i]
            if arr[i + 1] > max_val:
                max_val = arr[i + 1]
        else:
            if arr[i + 1] < min_val:
                min_val = arr[i + 1]
            if arr[i] > max_val:
                max_val = arr[i]
        i += 2

    # Handle the last element if the array length is odd
    if n % 2 != 0:
        if arr[n - 1] < min_val:
            min_val = arr[n - 1]
        elif arr[n - 1] > max_val:
            max_val = arr[n - 1]

    return min_val, max_val

# Example usage:
arr = [3, 7, 2, 9, 1, 5, 6]
min_val, max_val = findMinMax(arr)
print("Minimum:", min_val)
print("Maximum:", max_val)

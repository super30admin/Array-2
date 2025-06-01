#Time Compelxity: O(N)
#Space Complexity: O(1)
#Number of Comparisons: 1.5N

def find_min_max(arr):
    n = len(arr)

    # If there's only one element
    if n == 1:
        return arr[0], arr[0]

    # Initialize min and max
    if arr[0] < arr[1]:
        minimum = arr[0]
        maximum = arr[1]
    else:
        minimum = arr[1]
        maximum = arr[0]

    # Process pairs
    for i in range(2, n - 1, 2):
        if arr[i] < arr[i + 1]:
            if arr[i] < minimum:
                minimum = arr[i]
            if arr[i + 1] > maximum:
                maximum = arr[i + 1]
        else:
            if arr[i + 1] < minimum:
                minimum = arr[i + 1]
            if arr[i] > maximum:
                maximum = arr[i]

    # If odd number of elements, compare last one
    if n % 2 != 0:
        last = arr[-1]
        if last < minimum:
            minimum = last
        elif last > maximum:
            maximum = last

    return minimum, maximum
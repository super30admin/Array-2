# Time Complexity: O(N)
# Space Complexity : O(1)
# Swaps: Even: 3 N / 2 Odd: 3 (N / 2 + 1)

import math

def find_min_max(arr):

    min_val = arr[0]
    max_val = arr[0]

    n = len(arr)

    iters = math.ceil(n / 2)
    i = 0
    while i < len(arr):

        if i == len(arr) - 1:
            if arr[i] < min_val:
                min_val = arr[i]
            if arr[i] > max_val:
                max_val = arr[i]
        else:

            if arr[i] < arr[i + 1]:

                if arr[i] < min_val:
                    min_val = arr[i]
                if arr[i + 1] > max_val:
                    max_val = arr[i + 1]
            else:
                
                if arr[i] > max_val:
                    max_val = arr[i]
                if arr[i + 1] < min_val:
                    min_val = arr[i + 1]
        i += 2
    return min_val, max_val

arr = [2,8,6,2,11,5,20]

print(find_min_max(arr))
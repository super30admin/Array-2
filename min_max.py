"""
TC -> O(N)
SC -> O(1)
"""
def find_min_max(arr):
    n = len(arr)
    min_n = float('inf')
    max_n = -float('inf')
    i = 0
    if n % 2 != 0:
        min_n = min(min_n, arr[0])
        max_n = max(max_n, arr[0])
        i = 1
    while (i < n):
        n1 = arr[i]
        n2 = arr[i + 1]
        if n1 < n2:
            min_n = min(min_n, n1)
            max_n = max(max_n, n2)
        else:
            min_n = min(min_n, n2)
            max_n = max(max_n, n1)
        i += 2

    return min_n, max_n


print(find_min_max([1, 2, 3, 4, 2, 4, -9, 99, 12, 3]))

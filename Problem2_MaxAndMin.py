# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code run successfully: Yes

# Solution:
"""
1. Iterate through the array and find the lesser and greater value among every pair of numbers.
2. Compare the lesser value with the overall min and the greater one with the overall max and update the min and max.
3. Finally, return the overall min and the max values.
"""


def maxAndMin(self, arr: List[int]) -> List[int]:
    if not arr or len(arr) is 0:
        return []

    length = len(arr)

    # Initialize min and max value
    min_val = float('inf')
    max_val = float('-inf')

    # Initialize 2 pointers for comparing pair of numbers.
    i, j = 0, 1

    # Get the lesser and greater value among each pair of numbers and compare with the overall min and max values.
    while (i < length - 1) and (j < length):
        if arr[i] < arr[j]:
            min_val = min(min_val, arr[i])
            max_val = max(max_val, arr[j])
        else:
            min_val = min(min_val, arr[j])
            max_val = max(max_val, arr[i])
        i += 2
        j += 2

    if length % 2 is not 0:
        min_val = min(min_val, arr[length - 1])
        max_val = max(max_val, arr[length - 1])

    return [min_val, max_val]


'''
    Time Complexity:
        O(3n/2)

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Not on LeetCode.

    Problems faced while coding this:
        None

    Approach:
        Traverse the array in Pairs - O(n/2)
        -> For each itr, find smaller and bigger between the two - O(1)
        -> Find the minimum between the smaller and the current minimum - O(1)
        -> Find the maximum between the bigger and the current maximum - O(1)
'''
arr = [1000, 11, 445, 330, 3]

def find_min_max(self):
    minimum = float('inf')
    maximum = -float('inf')

    i = 0
    while i + 1 < len(arr):
        small, big = (arr[i], arr[i+1]) if arr[i] < arr[i+1] else (arr[i+1], arr[i])
        minimum = min(minimum, small)
        maximum = max(maximum, big)
        i += 2

    if i < len(arr):
        minimum = min(minimum, arr[i])
        maximum = max(maximum, arr[i])

    return (minimum, maximum)

print(find_min_max(arr))

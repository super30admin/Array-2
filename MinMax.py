# Time Complexity: O(n)
# Space Complexity: O(1)
def set_min(A):
    minimum = float('inf')
    for num in A:
        if num < minimum:
            minimum = num
    return minimum

def set_max(A):
    maximum = float('-inf')
    for num in A:
        if num > maximum:
            maximum = num
    return maximum
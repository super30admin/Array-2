# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Not on Leetcode
# Any problem you faced while coding this : No

def find_min_max(arr):
    """
    Returns the minimum and maximum of the array using fewer than 2*(N-2) comparisons.
    """
    n = len(arr)
    if n == 0:
        return None, None
    if n == 1:
        return arr[0], arr[0]
    if n % 2 == 0:
        if arr[0] < arr[1]:
            min_val, max_val = arr[0], arr[1]
        else:
            min_val, max_val = arr[1], arr[0]
        i = 2
    else:
        min_val = max_val = arr[0]
        i = 1
    while i < n - 1:
        if arr[i] < arr[i+1]:
            min_val = min(min_val, arr[i])
            max_val = max(max_val, arr[i+1])
        else:
            min_val = min(min_val, arr[i+1])
            max_val = max(max_val, arr[i])
        i += 2
    return min_val, max_val

# Example usage:
if __name__ == "__main__":
    arr = [3, 5, 1, 2, 4, 8, 0, -1]
    min_val, max_val = find_min_max(arr)
    print(f"Array: {arr}")
    print(f"Min: {min_val}, Max: {max_val}") 
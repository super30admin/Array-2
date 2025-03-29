# Problem2
# Given an array of numbers of length N, find both the minimum and maximum. 
# Follow up : Can you do it using less than 2 * (N - 2) comparison

# TC : O(n) - where n is the length of the array
#      Specifically, requires approximately 3n/2 - 2 comparisons

# SC : O(1) - uses only a constant amount of extra space

# Approach:
#     1. Handle edge cases (empty array or single element)
#     2. Initialize min and max by comparing the first two elements
#     3. Process the remaining elements in pairs to minimize comparisons:
#         - Compare the elements in each pair with each other
#         - Only compare the larger of the pair with current max
#         - Only compare the smaller of the pair with current min
#     4. Handle the last element separately if array length is odd

def find_min_max(arr):
    n = len(arr)
    
    # Handle edge cases
    if n == 0:
        return None, None # Return None for empty array
    if n == 1:
        return arr[0], arr[0] # If only one element, it's both min and max
    
    # Initialize min and max
    # Start by comparing first two elements
    if arr[0] > arr[1]:
        current_max = arr[0]
        current_min = arr[1]
    else:
        current_max = arr[1]
        current_min = arr[0]
    
    # Process the rest of the array in pairs
    # This is the key optimization - comparing elements in pairs
    i = 2
    while i < n - 1:
        if arr[i] > arr[i + 1]:
            # Compare larger of pair with current max
            if arr[i] > current_max:
                current_max = arr[i]
            # Compare smaller of pair with current min
            if arr[i + 1] < current_min:
                current_min = arr[i + 1]
        else:
            # Compare larger of pair with current max
            if arr[i + 1] > current_max:
                current_max = arr[i + 1]
            # Compare smaller of pair with current min
            if arr[i] < current_min:
                current_min = arr[i]
        i += 2
    
    # Handle the last element if array length is odd
    if n % 2 == 1:
        if arr[n - 1] > current_max:
            current_max = arr[n - 1]
        elif arr[n - 1] < current_min:
            current_min = arr[n - 1]
    
    return current_min, current_max

# Test with the provided examples
arr1 = [3, 5, 4, 1, 9]
min_val, max_val = find_min_max(arr1)
print(f"Input: arr[] = {arr1}")
print(f"Output: Minimum element is: {min_val}")
print(f"        Maximum element is: {max_val}")

arr2 = [22, 14, 8, 17, 35, 3]
min_val, max_val = find_min_max(arr2)
print(f"Input: arr[] = {arr2}")
print(f"Output: Minimum element is: {min_val}")
print(f"        Maximum element is: {max_val}")
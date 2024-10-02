# Time Complexity : O(n)
# Space Complexity : O(3N/2) - Even , O((N-1)/2) - Odd
# Did this code successfully run on Leetcode : no (geeksforgeeks problem)
# Any problem you faced while coding this : no
# Problem Name: max and min

def findMinAndMax(arr):
    n = len(arr)
    
    # If there is only one element
    if n == 1:
        return arr[0], arr[0]

    # Initialize min and max
    if n % 2 == 0:
        if arr[0] > arr[1]:
            minimum = arr[1]
            maximum = arr[0]
        else:
            minimum = arr[0]
            maximum = arr[1]
        start_index = 2
    else:
        maximum = minimum = arr[0]
        start_index = 1

    for i in range(start_index, n, 2):
        if i + 1 < n:
            if arr[i] > arr[i+1]:
                minimum = min(arr[i+1], minimum)
                maximum = max(arr[i], maximum)
            else:
                minimum = min(arr[i], minimum)
                maximum = max(arr[i+1], maximum)
    return minimum, maximum


# Examples:
arr1 = [3, 5, 4, 1, 9]
min_element, max_element = findMinAndMax(arr1)
print(f"Minimum element is: {min_element}")
print(f"Maximum element is: {max_element}")


arr2 = [22, 14, 8, 17, 35, 3]
min_element, max_element = findMinAndMax(arr2)
print(f"Minimum element is: {min_element}")
print(f"Maximum element is: {max_element}")
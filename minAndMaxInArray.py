# Time Complexity: O(n)
# Space Complexity: O(1)
# Number of comparisons: 3/2 * n
# Approach:
# 1. We initialize max and min with minim and maximum at 0th and 1st index
# 2. We initialize two pointers, i and j to iterate over the array, until j crosses the length of the array
# 3. At each iteration, we make 3 comparisons, 1 between i and j and then i or j with min and i or j with max

class Solution:
    def get_min_max(self, arr):
        if len(arr) == 1:
            mn = mx = arr[0]
            return [mn, mx]
            
        # Initializing the minimum and maximum values
        if arr[0] <= arr[1]:
            mn = arr[0]
            mx = arr[1]
        else:
            mx = arr[0]
            mn = arr[1]
            
        # Initializing the i and j pointers
        i, j = 2, 3
        
        while j < len(arr):
            if arr[j] <= arr[i]:
                mn = min(mn, arr[j])
                mx = max(mx, arr[i])
            else:
                mn = min(mn, arr[i])
                mx = max(mx, arr[j])
            # Incrementing pointers by two as we want to compare them with each other first.
            i += 2
            j += 2
        # If the length of the array is odd, we want to comapre the last index with both, minimum and maximum numbers
        if i == len(arr)-1:
            mn = min(mn, arr[i])
            mx = max(mx, arr[i])
        # Finally, return the minimum and maximum numbers calculated so far.
        return [mn, mx]


# Brute force approach
# Time Complexity: O(n)
# Number of Comparisons: 2*n - We make 2 comparisions for each element, 1 with mn and 1 with mx
# Space Complexity: O(1)
# Approach:
# 1. Initialize min and max variables to inf and -inf respectively.
# 2. Iterate over the input array and compare each element with min and max and update them if the element is smaller or larger than the current min and max.
class Solution:
    def get_min_max(self, arr):
        mx = float('-inf')
        mn = float('inf')
        for n in arr:
            mx = max(mx, n)
            mn = min(mn, n)
        
        return [mn, mx]
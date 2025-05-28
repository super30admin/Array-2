"""
Implemented using pairwise comparison to reduce the number of comparisons to approximately 1.5 * N instead of the naive 2 * (N - 1).
Time Complexity: O(n) 
Space Complexity: O(1)
"""
class Solution:
    def get_min_max(self, arr): 
        size = len(arr)
        if size == 0:
            return None
        if size == 1:
            return [arr[0], arr[0]]
        if arr[0] < arr[1]:
            minimum, maximum = arr[0], arr[1]
        else:
            minimum, maximum = arr[1], arr[0]
        
        for i in range(2, size - 1, 2):
            if arr[i] < arr[i + 1]:
                minimum = min(minimum, arr[i])
                maximum = max(maximum, arr[i + 1])
            else:
                minimum = min(minimum, arr[i + 1])
                maximum = max(maximum, arr[i])
                
        if size % 2 != 0:
            minimum = min(minimum, arr[-1])
            maximum = max(maximum, arr[-1])
        
        return [minimum, maximum]
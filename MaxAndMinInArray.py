# Time Complexity: O(N), total 3N/2 comparisons
# Space Complexity: O(1)
# Did this code successfully run on GeeksForGeeks: Yes

class Solution:
    def get_min_max(self, arr):
        minimum = float("inf")
        maximum = float("-inf")
        
        i = 0
        
        while i + 1 < len(arr):
            if arr[i] < arr[i + 1]:
                minimum = min(minimum, arr[i])
                maximum = max(maximum, arr[i + 1])
            else:
                maximum = max(maximum, arr[i])
                minimum = min(minimum, arr[i + 1])
            
            i += 2
        
        if len(arr) % 2 != 0:
            minimum = min(minimum, arr[len(arr) - 1])
            maximum = max(maximum, arr[len(arr) - 1])
        
        return [minimum, maximum]
            
        
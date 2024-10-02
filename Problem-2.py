class Solution:
    def get_min_max(self, arr):
        n = len(arr)
        minimum = float('inf')
        maximum = float('-inf')
        
        for i in range(0, n, 2):
            if i+1 < n:
                if arr[i] < arr[i+1]:
                    minimum = min(arr[i], minimum)
                    maximum = max(arr[i+1], maximum)
                else:
                    minimum = min(arr[i+1], minimum)
                    maximum = max(arr[i], maximum)
            else:
                minimum = min(arr[i], minimum)
                maximum = max(arr[i], maximum)
                
        return [minimum, maximum]
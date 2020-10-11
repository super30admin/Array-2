class Solution:
    def getMinMax(self, arr):
        n = len(arr)
        
        if n % 2 == 0:
            mx = max(arr[0], arr[1])
            mn = min(arr[0], arr[1])
            i = 2

        else:
            mn = mx = arr[0]
            i = 1

        while i < n-1:
            if arr[i] < arr[i+1]:
                mx = max(mx, arr[i+1])
                mn = min(mn, arr[i])
            else:
                mx = max(mx, arr[i])
                mn = min(mn, arr[i+1])
            i += 2
        return mx,mn


obj = Solution()
arr = [1000, 11, 445, 1, 330, 3000]
mx, mn = obj.getMinMax(arr)
print("Minimum element is", mn)
print("Maximum element is", mx)

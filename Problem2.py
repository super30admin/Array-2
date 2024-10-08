class Solution:
    def findmaxMin(self, arr):
        j = len(arr)-1
        i = 0
        tc = 0
        lowest = highest = arr[0]
        while i < j:
            tc = tc + 1
            highest = max(arr[i], arr[j], highest)
            tc = tc + 1
            lowest = min(arr[i], arr[j], lowest)
            i += 1
            j -= 1
        if i == j:
            highest = max(arr[i], highest)
            lowest = min(arr[i], lowest)
            tc = tc + 2
        
        print("Comparisons:", tc, "\nHighest is",highest,"\nLowest is",lowest)
        return tc, highest, lowest

s = Solution()
s.findmaxMin([4,3,2,7,8,2,3,1])
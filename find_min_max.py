# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this code we try to get the minimum and the maximum value of an array by comparing the elements in pairs.
"""

class Solution():
    def get_min_max(self, arr, low, high): # with minimum comparisions through tournaments.
        if len(arr[low:high+1]) == 1:
            return [arr[low], arr[low]]
        
        elif len(arr[low:high+1]) == 2:
            return [arr[low], arr[high]] if arr[low] < arr[high] else [arr[high], arr[low]]
        
        else:
            mid = (low+high)//2
            min1, max1 = self.get_min_max(arr, low, mid)
            min2, max2 = self.get_min_max(arr, mid+1, high)

            return [min(min1, min2), max(max1, max2)]

arr = [1000, 11, 445, 1, 330, 3000]

sol = Solution()
print(sol.get_min_max(arr, 0, len(arr)-1))

'''
Problem2
Given an array of numbers of length N, find both the minimum and maximum. 
Follow up : Can you do it using less than 2 * (N - 2) comparison
'''

# Time Complexity : O(N).  | 3 * (N/2) comparisions
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def findMinMax(self, arr: 'list[int]') -> None:
        if arr is None or len(arr) == 0:
            return None
            
        maxi = float('-inf')
        mini = float('inf')
        if len(arr)%2 == 0: # even length
            for i in range(0, len(arr), 2):
                if arr[i] < arr[i+1]:
                    mini = min(mini, arr[i])
                    maxi = max(maxi, arr[i+1])
                else:
                    mini = min(mini, arr[i+1])
                    maxi = max(maxi, arr[i])
        else:
            for i in range(0, len(arr)-1, 2):
                if arr[i] < arr[i+1]:
                    mini = min(mini, arr[i])
                    maxi = max(maxi, arr[i+1])
                else:
                    mini = min(mini, arr[i+1])
                    maxi = max(maxi, arr[i])
            
            mini = min(mini, arr[len(arr)-1])
            maxi = max(maxi, arr[len(arr)-1])
        
            print("min: {}, max: {}".format(mini, maxi))



s = Solution()
s.findMinMax([0, 1, 2, 3, 4])
s.findMinMax([10, 0, 1, 2, 3, 4, -1])
# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on GeeksForGeeks : Yes
# // Any problem you faced while coding this : No

class Solution:
    def getMinMax(self, arr):
        # code here
        n=len(arr)
        if n%2==0:
            start=2            
            if arr[0]>arr[1]:
                min_e=arr[1]
                max_e=arr[0]
            else:
                min_e=arr[0]
                max_e=arr[1]
        else:
            start=1
            min_e=arr[0]
            max_e=arr[0]
            
        i=start
        while(i<n):
            if (arr[i]>arr[i+1]):
                min_e=min(min_e,arr[i+1])
                max_e=max(max_e,arr[i])
            else:
                min_e=min(min_e,arr[i])
                max_e=max(max_e,arr[i+1])
            i+=2
        
        
        return [min_e,max_e]
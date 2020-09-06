# Time Complexity : O(3n/2+2) == O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach 

def getMinMax(arr):
    n = len(arr)

    # even
    if n % 2 == 0:
        mx = max(arr[0], arr[1])
        mn = min (arr[0], arr[1])
        i = 2
    else:
        mx = mn = arr[0]  #odd
        i = 1
    
    while i < n - 1:
        if arr[i] < arr[i+1]:
            mx = max(mx, arr[i+1])
            mn = min(mn, arr[i])
        else:
            mx = max(mx, arr[i])
            mn = min(mn, arr[i+1])

        i+= 2
    
    return (mx, mn) 


print (getMinMax([3,1,2,7,8]))


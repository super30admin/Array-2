# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

def getMinMax(arr):
    """
    Linear search approach
    """

    if not arr:
        return -1
    minVal = arr[0] 
    maxVal = arr[0]

    for i in range(1,len(arr)):
        if arr[i] < minVal:
            minVal = arr[i]
        if arr[i] > maxVal:
            maxVal = arr[i] 

    return [minVal, maxVal]
    

arr = [-12, 1,2,8,3,4,5]
#should return 1,5
print(getMinMax(arr))
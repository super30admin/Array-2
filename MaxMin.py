# // Time Complexity : O(N)
 # // Space Complexity : O(1)
 # // Did this code successfully run on Leetcode : Yes
def getMinMax(arr):
    n = len(arr)
    if n%2 == 0:
        Max = max(arr[0], arr[1])
        Min = min(arr[0], arr[1])
        i = 2
    else:
        Max,Min = arr[0]

    for j in range(i,len(arr)-2):
        if arr[i]< arr[i+1]:
            Max = max(arr[i+1],Max)
            Min = min(arr[i],Min)
        else:
            Max = max(arr[i], Max)
            Min = min(arr[i+1], Min)
    return (Max,Min)

arr = [1000, 11, 445, 1, 330, 3000]
print(getMinMax(arr))

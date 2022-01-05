def maxMin(arr):
    if not arr:
        return None, None
    alen = len(arr)
    maxm, minm = arr[0], arr[0]
    
    for i in range(1, alen - 1, 2):
        if arr[i] > arr[i+1]:
            maxm = max(arr[i], maxm)
            minm = min(arr[i + 1], minm)
        else:
            maxm = max(arr[i + 1], maxm)
            minm = min(arr[i], minm)
    
    if alen % 2 == 0:
        maxm = max(arr[alen - 1], maxm)
        minm = min(arr[alen - 1], minm)
    
    return maxm, minm

arr = [3,2,4,1,5,6]
print(maxMin(arr))
arr = [-3,2,14,1,51]
print(maxMin(arr))
arr = [2]
print(maxMin(arr))
arr = []
print(maxMin(arr))



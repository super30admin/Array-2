#Time Complexity: O(n)
#Space Complexity: O(1)

def MinandMax(arr):
    minimum = float('inf')
    maximum = float('-inf')
    n = len(arr)
    i=0
    while i<n-2:
        if arr[i]<=arr[i+1]:
            minimum = min(arr[i],minimum)
            maximum = max(arr[i+1],maximum)
        elif arr[i]>arr[i+1]:
            minimum = min(arr[i+1],minimum)
            maximum = max(arr[i],maximum)
        i+=2
    if n%2!=0:
        minimum = min(arr[n-1],minimum)
        maximum = max(arr[n-1],maximum)
    return minimum,maximum





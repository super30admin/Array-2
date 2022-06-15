# TC : O(N)
# SC : O(C)

def getMinMax(arr):     
    n = len(arr)
    if(n % 2 == 0):
        maximum = max(arr[0], arr[1])
        minimum = min(arr[0], arr[1])
        i = 2
         
    # If array has odd number of elements then initialize the first element as both minimum and maximum
    else:
        maximum = minimum = arr[0]
        i = 1
         
    # pair the elements and compare the pair with maximum and minimum so far
    while(i < n - 1):
        if arr[i] < arr[i + 1]:
            maximum = max(maximum, arr[i + 1])
            minimum = min(minimum, arr[i])
        else:
            maximum = max(maximum, arr[i])
            minimum = min(minimum, arr[i + 1])
             
        # since we pair up the elements
        i += 2
    return (maximum, minimum)
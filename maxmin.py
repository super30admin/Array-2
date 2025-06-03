def getMinMax(arr):
    
    n = len(arr)
    
    if(n % 2 == 0):
        if arr[0] < arr[1]:
            minn = arr[0]
            maxx = arr[1]
        else:
            minn = arr[1]
            maxx = arr[0]
        i = 2
    else:
        maxx = minn = arr[0]
        i = 1
    while(i < n - 1):
        if arr[i] < arr[i + 1]:
            maxx = max(maxx, arr[i + 1])
            minn = min(minn, arr[i])
        else:
            maxx = max(maxx, arr[i])
            minn = min(minn, arr[i + 1])
        i += 2
    
    return (mx, mn)

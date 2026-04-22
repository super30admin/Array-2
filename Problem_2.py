def find_min_max(arr):
    n = len(arr)
    mini,maxi = 0,0
    i = 0
    if n % 2 == 0:
        mini,maxi = arr[0],arr[0]
    else:
        if arr[i+1] > arr[i]:
            maxi = arr[i+1]
            mini = arr[i]
    i = 2
    
    while i < n-1:

        if arr[i+1] > arr[i]:
            maxi = max(maxi,arr[i+1])
            mini = min(mini,arr[i])
        else:
            maxi = max(maxi,arr[i])
            mini = min(mini,arr[i+1])
        i += 2
    return (mini,maxi)

nums = [3, 5, 4, 1, 9,-2]
print(find_min_max(nums))
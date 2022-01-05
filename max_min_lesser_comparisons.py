# Number of comparisons - 3n/2

def max_min_less_comparisons(arr):
    maxi = arr[0]
    mini = arr[0]
    for i in range(1,len(arr)-1):
        if arr[i]>arr[i+1]:
            maxi = max(maxi,arr[i])
            mini = min(mini,arr[i+1])
        else:
            maxi = max(maxi,arr[i+1])
            mini = min(mini,arr[i])
    return maxi,mini

arr = [10,8,4,7,2,6,1,5]
print(max_min_less_comparisons(arr))

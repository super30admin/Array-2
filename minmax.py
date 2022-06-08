# time complexity is o(n) and 3n/2 comparisons in total
# space complexity is o(1)
def minmax(arr):
    if(not len(arr)):
        return (0,0)

    if(len(arr) % 2 == 0):
        mini = min(arr[0], arr[1])
        maxi = max(arr[0], arr[1])
        i = 2
    else:
        mini = arr[0]
        maxi = arr[0]
        i =1
    while(i < len(arr)):
        if(arr[i] < arr[i+1]):
            maxi = max(maxi,arr[i+1])
            mini = min(mini, arr[i])
        else:
            maxi = max(maxi,arr[i])
            mini = min(mini, arr[i+1])
        i += 2
    return (maxi,mini)
print(minmax([23,45,8584,26,-2333,565,12,1,0]))
'''
Time Complexity: O(N)
Space Complexity: O(1)
'''
def maxMin(arr, n):
    i = 0
    if(n==1):
        return [arr[i], arr[i]]
    if(n%2 ==0):
        if(arr[i]>arr[i+1]):
            maxval = arr[i]
            minval = arr[i+1]
        else:
            maxval = arr[i+1]
            minval = arr[i]
        i = i+1
    elif(n%2==1):
        maxval = arr[i]
        minval = arr[i]
    i= i+1
    while(i<n-1):
        if(arr[i]>arr[i+1]):
            if(arr[i]>maxval):
                maxval = arr[i]
            if(arr[i+1]<minval):
                minval = arr[i+1]
        elif(arr[i+1]>arr[i]):
            if(arr[i+1]>maxval):
                maxval = arr[i+1]
            if(arr[i]<minval):
                minval = arr[i]
        i = i+2
    return [minval, maxval]



nums =[220, 14, 8, 17, 35]
val = maxMin(nums, 5)
print(val)
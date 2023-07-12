# Time: O(n)
# Space: O(1)
# number of comaparisions: if size is odd: 3*(n-1)/2; else: 3*(n-2)/2 + 1
# compare in pairs a,b hence n/2 term in comparisions
# 
def getMinMax(arr, size):
    if size%2==0:
        start = 2
        if arr[0] > arr[1]: #1 comparision
            Min, Max = arr[1], arr[0]
        else:
            Min, Max = arr[0], arr[1]
    else:
        start = 1
        Min, Max = arr[0], arr[0]
        
    for i in range(start, size, 2): #if size is odd n-1 times, else n-2 times
        if arr[i] > arr[i+1]: #comparision1
            Min, Max = min(Min, arr[i+1]), max(arr[i], Max) #comparision 2 and 3
        else:
            Min, Max = min(arr[i], Min),max(arr[i+1], Max)
    return {'min':Min, 'max':Max}
    

# Driver Code
if __name__ == "__main__":
    arr = [1000, 11, 445, 1, 330, 3000]
    arr_size = 6
    minmax = getMinMax(arr, arr_size)
    print("Minimum element is", minmax['min'])
    print("Maximum element is", minmax['max'])
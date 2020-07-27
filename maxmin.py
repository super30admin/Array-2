def maxmin(arr):
    n=len(arr)
    #condition to find whether array with even size or odd size
    if n%2==0:
        #initializing maximum and minimum for even sized array
        minimum=min(arr[0],arr[1])
        maximum=max(arr[0],arr[1])
        i=2
    else:
        #initializing maximum and minimum for odd sized array
        maximum=minimum=arr[0]
        i=1
    #traversing remainder of array by dividing into 2 elements each
    while i<n-1:
        if arr[i]<arr[i+1]:
            #updating maximum and minimum
            maximum=max(maximum,arr[i+1])
            minimum=min(minimum,arr[i])
        else:
            #updating maximum and minimum
            maximum=max(maximum,arr[i])
            minimum=min(minimum,arr[i+1])
        i+=2
    return maximum,minimum

#Time Complexity: O(n)
#Space Complexity:O(1)
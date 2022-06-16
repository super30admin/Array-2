'''Time Comlexity: O(n)
Space Complexity: O(1)
Number of comparisons: 1.5n'''
def MinMax(arr):
    maxnum=arr[0]
    minnum=arr[0]
    for i in range(len(arr)-1):
        #check in pairs
        if arr[i]>arr[i+1]:
            maxnum=max(maxnum, arr[i])
            minnum=min(minnum, arr[i+1])
        else:
            maxnum=max(maxnum, arr[i+1])
            minnum=min(minnum, arr[i])
            
    return maxnum, minnum
    
arr=[1,2,4,-2,3,6,7,-7]
print(MinMax(arr))

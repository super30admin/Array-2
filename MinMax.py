# Time Complexity :O(n)
# Space Complexity :O(log n)-For recursion call stack
# T(n) = 2 T(n/2) + 2
# T(2) = 1
# T(1) = 0
# We can solve this recurrence relation by master method/recursion tree method.
# if n is a power of 2
# T(n) = 3n/2 - 2 comparisions
#If arr size is 1: return the first element as min and max
#If the array size is 2: Compare between two numbers and return min and max
#Else recursively store and calculate min and max of the left and right array. 
#determine the minimum and maximum value after comparision.


def MinMax(l,r,arr):
    arr_max=arr[l]
    arr_min=arr[l]
    if l==r:
        arr_max=arr[l]
        arr_min=arr[l]
        return (arr_max,arr_min)
    elif r==l+1:
        if arr[l]>arr[r]:
            
            arr_max=arr[l]
            arr_min=arr[r]
        else:
            arr_min=arr[l]
            arr_max=arr[r]

        return (arr_max,arr_min)
    
    else:
        mid=l+(r-l)//2
        arr_max1,arr_min1=MinMax(l,mid,arr)
        arr_max2,arr_min2=MinMax(mid+1,r,arr)
    return(max(arr_max1,arr_max2),min(arr_min1,arr_min2))

        
        

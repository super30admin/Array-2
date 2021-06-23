from typing import List

def get_min_max(arr):
    length = len(arr)

    #checking if the length of the array is odd or even
    if(length %2 ==0):
        mx = max(arr[0],arr[1])
        mn = min(arr[0],arr[1])

        i=2
    else:
        mx = arr[0]
        mn = arr[1]

        i=1
    #Loop over length of array to find the max and min elements in the array
    while(i<length-1):
        if arr[i] <arr[i+1]:
            mx = max(mx,arr[i+1])
            mn = min(mn,arr[i])

        else:
            mx = max(mx,arr[i])
            mn = min(mn,arr[i+1])
            i+=2
    return (mx,mn)


array = [200,3000,2404,2045,4669]

mx,mn = get_min_max(array)
print("Maximum value",mx)
print("Minimum value",mn)

#This problem finds out the maximum and minimum value of the array
#Time complexity - O(n)
#Space complexity - O(1)


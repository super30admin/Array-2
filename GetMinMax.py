# Time complexity is O(n) n is the number of elements in array
# space complexity is O(1) we do not  use any space for compute

# This function will return min and max in an array
def getMinMax(arr):

    arrLen = len(arr)
    mini = 999999999
    maxi = -99999999

    if arrLen == 1:
        mini = arr[0]
        maxi = arr[1]

    if arrLen % 2 == 0:
        start = 0
    else:
        mini = arr[0]
        maxi = arr[0]
        start = 1

    for i in range(start, arrLen, 2):
        if arr[i] > arr[i+1]:
            mini = arr[i+1]
            maxi = arr[i-1]
        else:
            mini = arr[i-1]
            maxi = arr[i+1]
    return [mini, maxi]


print(getMinMax(arr=[1000, 11, 445, 1, 330, 3000]))

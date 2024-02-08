# Time complexity is O(n) n is the number of elements in array
# space complexity is O(1) we do not  use any space for compute

# This function will return min and max in an array
def getMinMax(arr):

    arrLen = len(arr)
    mini = 999999999
    maxi = -99999999

    if arrLen % 2 == 0:
        start = 0
    else:
        mini = arr[0]
        maxi = arr[0]
        start = 1

    for i in range(start, arrLen, 2):

        if arr[i] > arr[i+1]:
            if arr[i] > maxi:
                maxi = arr[i]
            if arr[i+1] < mini:
                mini = arr[i+1]
        else:
            if arr[i+1] > maxi:
                maxi = arr[i+1]
            if arr[i] < mini:
                mini = arr[i]
    return [mini, maxi]


print(getMinMax(arr=[-2, 1, -4, 5, 3]))

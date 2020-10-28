# Simple way is  to iterate through array but to reduce the number of comparisons I assigned the first and second element of array as minimum and maximum then  iterted over the entire array.
# Time complexity: O(len(arr)-2)
# Space complxity: O(1)
def minMax(arr):
    if (arr is None or len(arr)==0):
        return (0,0)
    mini = 0
    maxi = 0
    if (arr[0]>arr[1]):
        mini = arr[1]
        maxi = arr[0]
    else:
        mini = arr[0]
        maxi = arr[1]
    for i in range(2,len(arr)):
        if arr[i] > maxi:
            maxi = arr[i]
        elif arr[i] < mini:
            mini = arr[i]
    return (mini,maxi)


arr = [2,5,1,3,6]
tup = minMax(arr)
print(tup)
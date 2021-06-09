# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
def getMinMax(arr):
    n = len(arr)

    if (n % 2 == 0):
        maxi = max(arr[0], arr[1])
        mini = min(arr[0], arr[1])

        i = 2
    else:
        maxi = mini = arr[0]
        i = 1

    while (i < n - 1):
        if arr[i] < arr[i + 1]:
            maxi = max(maxi, arr[i + 1])
            mini = min(mini, arr[i])
        else:
            maxi = max(maxi, arr[i])
            mini = min(mini, arr[i + 1])

        i += 2

    return (maxi, mini)


if __name__ == '__main__':
    arr = [1000, 11, 445, 1, 330, 3000]
    maxi, mini = getMinMax(arr)
    print("Minimum element in the array is", mini)
    print("Maximum element in the array is", maxi)


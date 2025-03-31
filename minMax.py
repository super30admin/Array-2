# This function finds the minimum and maximum values in an array with reduced comparisons.
# It compares elements in pairs, reducing the total number of comparisons to about 3n/2.
# Time Complexity: O(n), Space Complexity: O(1)

def getMinMax(arr):
    n = len(arr)

    if n % 2 == 0:
        if arr[0] < arr[1]:
            mn = arr[0]
            mx = arr[1]
        else:
            mn = arr[1]
            mx = arr[0]
        i = 2
    else:
        mx = mn = arr[0]
        i = 1

    while i < n - 1:
        if arr[i] < arr[i + 1]:
            mx = max(mx, arr[i + 1])
            mn = min(mn, arr[i])
        else:
            mx = max(mx, arr[i])
            mn = min(mn, arr[i + 1])
        i += 2

    return (mx, mn)


arr = [1000, 11, 445, 1, 330, 3000]
mx, mn = getMinMax(arr)
print("Minimum element is", mn)
print("Maximum element is", mx)

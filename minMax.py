# Time Complexity: O(n)
# Space Complexity: O(1)
# 1.5 n comparisons
def minMax(arr):
    n = len(arr)
    maxN = -999
    minN = 999

    for i in range(n-1):
        if arr[i] > arr[i+1]:
            maxN = max(maxN, arr[i])
            minN = min(minN, arr[i+1])
        else:
            maxN = max(maxN, arr[i+1])
            minN = min(minN, arr[i])

    return [minN, maxN]

if __name__ == "__main__":
    arr = [3, 1, -1, 4, 5, 6, 0]
    print(minMax(arr))

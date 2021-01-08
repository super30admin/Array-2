# Created by Aashish Adhikari at 9:23 PM 1/7/2021

'''
Time Complexity:
O(sum of absolute value of all elements of the input array)


Space Complexity:
O(sum of absolute value of all elements of the input array)

'''

class pair:
    def __init__(self):
        self.min = 0
        self.max = 0

def getMinMax(arr: list, n: int) -> pair:
    minmax = pair()


    if n == 1:
        minmax.max = arr[0]
        minmax.min = arr[0]
        return minmax


    hs = set()

    sum = 0

    for idx in range(n):
        sum += abs(arr[idx])

    for idx in range(0,n):
        if arr[idx] not in hs:
            hs.add(arr[idx])

    import sys
    minmax.min = 1 * sys.maxsize
    minmax.max = -1 * sys.maxsize

    for item in hs:
        if item < minmax.min:
            minmax.min = item

        if item > minmax.max:
            minmax.max = item


    return minmax

# Driver Code
if __name__ == "__main__":
    arr = [1000, 11, 445, 1, 330, 3000]
    arr_size = 6
    minmax = getMinMax(arr, arr_size)
    print("Minimum element is", minmax.min)
    print("Maximum element is", minmax.max)
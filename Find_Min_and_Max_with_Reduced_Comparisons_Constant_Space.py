# Created by Aashish Adhikari at 9:41 PM 1/7/2021

'''

Brute Force makes 2n comparisons. Here the # of comparisons is (3/2) n.


Time Complexity:
O(n)


Space Complexity:
O(1)

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

    import sys
    minmax.max = -1 * sys.maxsize
    minmax.min = sys.maxsize

    for idx in range(0,n,2):

        if arr[idx] < arr[idx+1]:
            if arr[idx] < minmax.min:
                minmax.min = arr[idx]
            if arr[idx + 1] > minmax.max:
                minmax.max = arr[idx + 1]
        else:
            if arr[idx] > minmax.max:
                minmax.max = arr[idx]
            if arr[idx + 1] < minmax.min:
                minmax.min = arr[idx + 1]

    # if odd, compare with the last element
    if n%2 == 1:
        if minmax.min > arr[-1]:
            minmax.min = arr[-1]
        if minmax.max < arr[-1]:
            minmax.max = arr[-1]

    return minmax

# Driver Code
if __name__ == "__main__":
    arr = [1000, 11, 445, 1, 330, 3000]
    arr_size = 6
    minmax = getMinMax(arr, arr_size)
    print("Minimum element is", minmax.min)
    print("Maximum element is", minmax.max)
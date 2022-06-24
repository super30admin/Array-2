class pair:
    #O(n) - Time complexity where n is the size of the array; O(1) - Space complexity
    def __init__(self):
        self.min = 0
        self.max = 0
 
def getMinMax(arr: list, n: int) -> pair:
    min_max = pair()
 

    if n == 1:
        min_max.max = arr[0]
        min_max.min = arr[0]
        return min_max
 
  
    if arr[0] > arr[1]:
        min_max.max = arr[0]
        min_max.min = arr[1]
    else:
        min_max.max = arr[1]
        min_max.min = arr[0]
 
    for i in range(2, n):
        if arr[i] > min_max.max:
            min_max.max = arr[i]
        elif arr[i] < min_max.min:
            min_max.min = arr[i]
 
    return min_max
 
# Driver Code
if __name__ == "__main__":
    arr = [1000, 11, 445, 1, 330, 3000]
    arr_size = 6
    min_max = getMinMax(arr, arr_size)
    print("Minimum:", min_max.min)
    print("Maximum:", min_max.max)

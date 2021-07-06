def findMinMax(arr):
    pair=minmaxPair()
    for i in range(len(arr)):
        if arr[i]<pair.min:
            pair.min=arr[i]
        if arr[i]>pair.max:
            pair.max=arr[i]
    print(pair.max,pair.min)
    return pair.max,pair.min


class minmaxPair:
    def __init__(self):
        self.min=float("inf")
        self.max=float("-inf")
        
arr = [100, 11, 300, 2,1,44, 330, 23]
findMinMax(arr)
#Time O(n)
#Space O(1)
#Run succefully the first part of question. 

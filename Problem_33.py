# TC: O(n)
# SC: O(1)

def getMinMax(arr):
    minimum = float('inf')
    maximum = float('-inf')
    
    for i in arr:
        if minimum > i:
            minimum = i
        if maximum < i:
            maximum = i
    return maximum, minimum
    
if __name__ =='__main__':
      
    arr = [1000, 11, 445, 1, 330, 3000]
    mx, mn = getMinMax(arr)
    print("Minimum element is", mn)
    print("Maximum element is", mx)
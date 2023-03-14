# TC: O(n)
# SC: O(1)



def getMinMax(arr):
    minimum = arr[0]
    maximum = arr[0]
    
    i = 1
    while i < len(arr) - 1:
        if arr[i] > arr[i+1]:
            maximum = max(maximum, arr[i])
            minimum = min(minimum, arr[i+1])
        else:
            maximum = max(maximum, arr[i+1])
            minimum = min(minimum, arr[i])
        i += 2
        
    if i == len(arr) - 1:
        maximum = max(maximum, arr[i])
        minimum = min(minimum, arr[i])
        
    return maximum, minimum
    
if __name__ =='__main__':
      
    arr = [1000, 11, 445, 1, 330, 3000]
    mx, mn = getMinMax(arr)
    print("Minimum element is", mn)
    print("Maximum element is", mx)
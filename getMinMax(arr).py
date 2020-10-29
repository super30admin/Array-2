"""
Time complexity is O(n)
Space complexity O(1)
 If n is odd---> 3*(n-1)/2  
If n is even--->  1 + 3*(n-2)/2 = 3n/2 -2
"""
def getMinMax(arr): 
    n = len(arr)
    if(n % 2 == 0):
        max1 = max(arr[0], arr[1])
        min1 = min(arr[0], arr[1])
        i = 2
    else:
        max1 = min1 = arr[0] 
        i = 1
    while(i < n - 1):
        if arr[i] < arr[i + 1]:
            max1 = max(max1, arr[i + 1])
            min1 = min(min1, arr[i])
        else:
            max1 = max(max1, arr[i])
            min1 = min(min1, arr[i + 1])
        i += 2
    return (max1, min1)
     

if __name__ =='__main__':
     
    arr = [1000, 11, 45, 1, 330, 30]
    max1, min1 = getMinMax(arr)
    print("Minimum element is", min1)
    print("Maximum element is", max1)
     

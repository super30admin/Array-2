# Time Complexity : O(N) //As it would run for the whole of the array
#  Space Complexity : O(1) //As we are using the same array and returning the variables 
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : Had to refine m and n again in the countLives function

def getMinMax(arr):
     
    n = len(arr)
    #Initialize the first two elements as min and max.If array has even number of elements then
    if(n % 2 == 0):
        maxElem = max(arr[0], arr[1])
        minElem = min(arr[0], arr[1])

        index = 2
         
    # For odd number of elements then the first elem is min and max
    else:
        maxElem = minElem = arr[0]
         
        index = 1
         
    # In the while loop, pick elements in pair and
    # compare the pair with max and min so far
    while(i < n - 1):
        if arr[i] < arr[i + 1]:
            maxElem = max(maxElem, arr[i + 1])
            minElem = min(minElem, arr[i])
        else:
            maxElem = max(maxElem, arr[i])
            minElem = min(minElem, arr[i + 1])
             
        # Increment the index by 2 as two elements are processed in loop

        index += 2
     
    return (maxElem, minElem)
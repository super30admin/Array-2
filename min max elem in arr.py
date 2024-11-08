# TC: O(1.5n)
# SC: O(1)
# This is not a leetcode problem

def minMax(arr):
    if arr is None:
        return
    
    n = len(arr)
    minE = arr[n-1] #This will take care of the case where len(arr) is odd
    maxE = arr[n-1] #This will take care of the case where len(arr) is odd
    for i in range(n-1):
        if arr[i] < arr[i+1]:
            minE = min(arr[i], minE)
            maxE = max(arr[i+1], maxE)
        else:
            minE = min(arr[i+1], minE)
            maxE = max(arr[i], maxE)
    return minE, maxE
                
# Another potential approach: For every iteration, check if the minE value is updated. If it gets changed, move to the next iteration.
# If the value remains the same, update the maxE value. This is based on the intuition that if we are changing the min value in an array,
# then we know for a fact that value cannot be the max value and vice-versa.

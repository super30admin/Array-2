# S30 Big N Problem #31 {Easy }

# An array of numbers of length N is given , you need to find the minimum and maximum. try doing this in less than 2* (N-2) comparisons


# Time Complexity : O(n/2) n= no. of elements in the array
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach 
# Traverse through the array in pairs
# Maintain a global minimum and maximum variable
# For every pair, update the minimum and maximum value

def findMinMax(arr,minimum,maximum):
    
    length=0
    isOdd=False
    if len(arr)%2!=0:
        length=len(arr)-1
        isOdd=True
    else:
        length=len(arr)
        
    for i in range(0,length,2):
        
        tempmin=0
        tempmax=0
        if arr[i]>arr[i+1]:
            tempmax=arr[i]
            tempmin=arr[i+1]
        else:
            tempmin=arr[i]
            tempmax=arr[i+1]
        
        minimum=min(minimum,tempmin)
        maximum=max(maximum,tempmax)
        
    if isOdd:
        minimum=min(minimum,arr[len(arr)-1])
        maximum=max(maximum,arr[len(arr)-1])
        
        
    
    print(minimum,maximum)
            

arr=[5,6,7,9,1,2,18]

minimum=float('inf')
maximum=0

findMinMax(arr,minimum,maximum)
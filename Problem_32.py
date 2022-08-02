# Time Complexity : The number of comparisions is 3*(n-1)/2 for even numbers and 3*(n-1)/2 +2 for odd numbers, both of which are better than 2*(n-2)
# Space Complexity : O(1) or  constant auxiliary space is needed

def getMinMax(arr):
     
    n = len(arr)
    maxi = -float('inf')
    mini = float('inf')
    for i in range(0,n-1,2): # Loop will run (n-1)/2 times 
        if(arr[i]<arr[i+1]): # 1st comparision
            lmax = arr[i+1]
            lmin = arr[i]
        else:
            lmax = arr[i]
            lmin = arr[i+1]
        if lmax > maxi: # 2nd comparision
            maxi = lmax
        if lmin < mini: # 3rd comparision
            mini = lmin
    if n%2 != 0:
        if arr[n-1] > maxi:
            maxi = arr[n-1]
        elif arr[n-1] < mini:
            mini = arr[n-1]

        
    return (maxi, mini)

arr = [1,3,4,5,6,7,9]
print("Max and Min in this array are: " + str(getMinMax(arr)))
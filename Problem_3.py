def MinMax(arr): 

    n = len(arr)
    # For even:
    if(n % 2 == 0): 
        maxx = max(arr[0], arr[1]) 
        minn = min(arr[0], arr[1]) 
        i = 2
    # For ODD:
    else: 
        maxx = minn = arr[0] 
        i = 1
          
    # Compare max and min
    for i in range(i, n-1,2):
        if arr[i]<arr[i+1]:
            maxx = max(maxx, arr[i+1])
            minn = min(minn, arr[i])
        else:
            maxx = max(maxx, arr[i]) 
            minn = min(minn, arr[i+1])
      
    return [maxx, minn]
      
# Main function
arr = [45,32,12,56,345] 
res = MinMax(arr) 
print("Minimum element is", res[1]) 
print("Maximum element is", res[0]) 


# Time Complexity: O(n) --> If even = 3n/2 -2 and If odd = 3*(n-1)/2
# Space Complexity: O(1)
# Accepted on Leetcode: YES
# Any problems faced: No.
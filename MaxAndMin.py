# Time Complexity : O(n) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : N/A
# Any problem you faced while coding this : Why do we have to check the last element separately

# Your code here along with comments explaining your approach
def find_min_max(arr):
    m = len(arr)
    #According to python standard we can initialise infinity only with float datatype
    #Integer types in Python do not have an inherent representation for infinity because they can grow as large as memory allows
    minimum = float('inf')
    maximum = float('-inf')

    # Iterate only up to m - 1
    for i in range(0, m-1):
        #If arr[i] < arr[i+1] check min b/w arr[i] and min; check max b/w arr[i+1] and max
        if arr[i] < arr[i + 1]:
            minimum = min(arr[i], minimum)
            maximum = max(arr[i + 1], maximum)
        #Else arr[i] <=>= arr[i+1] check min b/w arr[i+1] and min; check max b/w arr[i] and max
        else:
            minimum = min(arr[i + 1], minimum)
            maximum = max(arr[i], maximum)

    # Check the last element separately
    minimum = min(arr[m - 1], minimum)
    maximum = max(arr[m - 1], maximum)

    return minimum, maximum
    
arr = [3, 5, 4, 1, 9]
min_val, max_val = find_min_max(arr)
print("The minimum number is:", min_val)
print("The maximum number is:", max_val)

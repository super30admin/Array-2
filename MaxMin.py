"""Maximum and Minimum element in an array
Time Complexity: O(n)
Space Complexity: O(1)
 2* (N-2) comparisons
"""

def maxminarray(arr):
    n = len(arr) 
    max_ele = min_ele = arr[0]
    i = 1
    if n%2==0:
        max_ele = max(arra[0],arr[1])
        min_ele = min(arra[0],arr[1])
        i =2
    while i<n-1:
        if arr[i] < arr[i + 1]:
            max_ele = max(max_ele, arr[i + 1])
            min_ele = min(min_ele, arr[i])
        else:
            max_ele = max(max_ele, arr[i])
            min_ele = min(min_ele, arr[i + 1])
        i+=2
    return (max_ele,min_ele)







arr = [3,6,1,5,2]
max_ele,min_ele = maxminarray(arr)
print(max_ele,min_ele)

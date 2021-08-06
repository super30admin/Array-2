"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
def findMinMax(arr):
    # Pointer to determine the start of search
    k = 0
    # If even length 1st and 2nd element would be 
    # my min or max and pointer would be 2 as we can 
    # search in pairs
    if len(arr)%2 == 0:
        k = 2
        maxi = max(arr[0], arr[1])
        mini = min(arr[0], arr[1])
    # If odd length then 1st element would be both my
    # max and min and pointer would be 1
    else:
        k = 1
        maxi = mini = arr[0]
    # Traverse through array from the pointer and
    # compare the elements in pairs
    for i in range(k, len(arr) - k, k):
        if arr[i] < arr[i + 1]:
            maxi = max(maxi, arr[i + 1])
            mini = max(mini, arr[i])
            print(maxi, mini)
        else:
            maxi = max(maxi, arr[i])
            mini = min(mini, arr[i + 1])
            print(maxi, mini)
    return (mini, maxi)

mn, mx = findMinMax([100, 11, 40, 1, 33])
print("Minimum:",mn)
print("Maximum:",mx)
# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Don't know whethter this is optimal

def min_and_max(arr):
    arr_size = len(arr)
    min = 0
    max = 0

    if arr_size == 1: 
            max = arr[0] 
            min = arr[0]

    if arr[0] > arr[1]: 
        max = arr[0] 
        min = arr[1] 
    else: 
        max = arr[1] 
        min = arr[0] 

    for i in range(2, arr_size): 
        if arr[i] > max: 
            max = arr[i] 
        elif arr[i] < min: 
            min = arr[i]
    print("Minimum element is", min) 
    print("Maximum element is", max) 
arr = [1000, 11, 445, 1, 330, 3000] 
min_and_max(arr)
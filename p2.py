## Problem2
# Given an array of numbers of length N, find both the minimum and maximum. 
# Follow up : Can you do it using less than 2 * (N - 2) comparison
arr = [7,2,3,4, 8,6,9, 11, 12]
def min_and_max(arr):
    min_num, max_num = arr[0], arr[0] 
    for i in range(1, len(arr)):
        if arr[i] > arr[i-1]:
            max_num = max(max_num, arr[i])
            print(arr[i])
        else:
            min_num = min(min_num, arr[i])
    print(min_num, max_num)
min_and_max(arr)
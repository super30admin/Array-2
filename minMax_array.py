# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : not in Leetcode, executed in PyCharm
# Any problem you faced while coding this : no

def minMax(arr):
    num = len(arr)
    # edge case
    if num == 0:
        return

    if num % 2 == 0:  # array with even elements
        max_num = max(arr[0], arr[1])
        min_num = min(arr[0], arr[1])
        i = 2
    else:
        max_num = min_num = arr[0]  # array with odd elements
        i = 1
    # pair elements and compare with min and max numbers
    while i < num - 1:
        if arr[i] < arr[i + 1]:
            max_num = max(max_num, arr[i + 1])
            min_num = min(min_num, arr[i])
        else:
            max_num = max(max_num, arr[i])
            min_num = min(min_num, arr[i + 1])
        i += 2
    return max_num, min_num


arr = [100, 300, 2, 20, 1000, 1]
max_num, min_num = minMax(arr)
print("Maximum is", max_num, "\nMinimum is", min_num)

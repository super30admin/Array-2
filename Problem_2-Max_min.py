# APPROACH:  1
# Time Complexity : O(n) -> (3/2)n - 2 comparisons
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : N/A
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Compare elements in groups of 2 - get local min and local max
# 2. Then compare local min with global min and local max with global max
# 3. Initialize global max and min to first element st number of comparisons is reduced by 2 (anyways get compared with 1st pair)


def max_min(arr):

    if not arr:
        return None

    if len(arr) == 1:
        return arr[0]

    local_max, local_min, global_max, global_min, ind = arr[0], arr[0], arr[0], arr[0], 1

    while ind < len(arr):

        if (ind + 1) < len(arr):
            if arr[ind] < arr[ind + 1]:
                local_min = arr[ind]
                local_max = arr[ind + 1]
            else:
                local_min = arr[ind + 1]
                local_max = arr[ind]

            global_max = max(global_max, local_max)
            global_min = min(global_min, local_min)
            ind += 2

        else:
            local_max, local_min = arr[-1], arr[-1]
            global_max = max(global_max, local_max)
            global_min = min(global_min, local_min)
            ind += 1

    return global_max, global_min


arr = [9, 1, 7, 1, 2, 3, 8, 0]
result = max_min(arr)
print(result)

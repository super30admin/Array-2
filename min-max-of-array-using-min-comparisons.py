# Problem: Given an array of size N. The task is to find the maximum and the minimum element of the array using the minimum number of comparisons.

# Solution: 
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on geeksforgeeks : yes

# There are a few ways to solve this - 1. You can sort the array, and return the first &
# last elements repectively. This is the easiest method, and can be done in O(logn) time
# 2. Another way is to have min & max variables, and compare each element with them & update
# as we go along. This takes O(n) time.
# 3. We can modify approach 2 and instead compare in pairs, and the advantage of this is 
# that it will save us some comparisons. Since thats the goal, lets go ahead with this
# (cant use sorting approach as sorting itself take nlogn comparisons, which is kinda hgih)

class Solution:
    def get_min_max(self, arr):
        n = len(arr)
        # if array length is even, select min & max from 1st & 2nd element
        # If length is odd, initialize first element as both min & max, as this allows us 
        # continue the rest of the comparisons in pairs
        if n % 2 == 0:
            if arr[0] > arr[1]:
                arr_max = arr[0]
                arr_min = arr[1]
            else:
                arr_max = arr[1]
                arr_min = arr[0]
            index = 2
        else:
            arr_max = arr[0]
            arr_min = arr[0]
            index = 1
            
        while index < n-1:
            if arr[index] < arr[index + 1]:
                arr_min = min(arr[index], arr_min)
                arr_max = max(arr[index + 1], arr_max)
            else:
                arr_min = min(arr[index + 1], arr_min)
                arr_max = max(arr[index], arr_max)
            index += 2
        return arr_min, arr_max
            
# Array-2
## Problem2
#Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

# Approach
# Traverse through the array till 2nd last element. Each time check whether the element at i < i+1.
# If yes, compare element at i with min_val and element at i+1 with max_value. Else, vice-versa
# Return min and max value

# T.C : O(n/2)
# S.C : O(1)

class Solution:
    def minMax(arr):
        if len(arr) == 0:
            print('Array is empty')
            return
        min_num = arr[0]
        max_num = arr[0]
        for i in range(0,len(arr),2):
            if i == len(arr)-1:
                max_num = max(max_num,arr[i])
                min_num = min(min_num,arr[i])
            elif arr[i] < arr[i+1]:
                max_num = max(max_num,arr[i+1])
                min_num = min(min_num,arr[i])
            else:
                max_num = max(max_num,arr[i])
                min_num = min(min_num,arr[i+1])

        return ("min_num",min_num,' ','max_num',max_num)   
        # print("min_num",min_num)
        # print("max_num",max_num)
            
    minMax([4,2,-1,0,8,7,3,-2,9])
        
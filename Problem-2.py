#Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

# Approach
# instead of looping the array for min max seperately we can take 2 numbers ata time and compare both and update the min and max


# Complexities
# Time Complexity: O(n) -  3(N-1)/2 comparisions 
# Space Complexity: O(1)

def minMax(arr):
    if len(arr)==1:
        return arr[0],arr[0]
    min_num  = float("inf")
    max_num = float("-inf")
    for i in range(0,len(arr)-1,2):
        if arr[i]<arr[i+1]:
            min_num = min(min_num, arr[i ])
            max_num = max(max_num, arr[i+1])
        else:
            min_num  =  min(min_num,arr[i+1])
            max_num = max(max_num,arr[i])

    if len(arr) % 2 != 0:
        min_num = min(min_num, arr[-1])
        max_num = max(max_num, arr[-1])

    return min_num, max_num



print(minMax([4,1,7,6,3]))
'''
SOl 1:
Time Complexity :O(n) 2*(N-2)Comparisons
Space Complexity: O(1)
Did this code successfully run on Leetcode : No Question on leetcode
Explanation:
Choose min and max values and iterate through the array until we find minimum and maximum value

SOl 2:
Time Complexity :O(n) 3N/2-2 as 2T(n/2) + 2 for even
Space Complexity: O(1)
Did this code successfully run on Leetcode : No Question on leetcode
Explanation:
Divide and conquer approach find min and max respectively on either side by breaking it into smaller sub problems
'''
def minMax(arr):
    min = arr[0]
    max = arr[0]
    if arr == None or len(arr) == 0 :
        return []
    for i in range(0,len(arr)):
        if max < arr[i]:
            max = arr[i]

        if min > arr[i]:
            min = arr[i]

    return [min, max]

def minMax2(arr, index1, index2):
    if index1 == index2:
        return (arr[index1],arr[index2])
    elif len(arr) == 2:
        return (min(index1,index2), max[index1,index2])
    else:
        mid = (index1 + (index2 - index1)/2)
        min1, max1 = minMax2(arr,index1,mid)
        min2, max2 = minMax2(arr,mid+1,index2)
        return (min(min1, min2), max(max1,max2))

arr = [3,5,2,8,1]
print(minMax2(arr, 0, len(arr)-1))
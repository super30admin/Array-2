'''
SOl 1:
Time Complexity :O(n) 2*(N-2)Comparisons
Space Complexity: O(1)
Did this code successfully run on Leetcode : No Question on leetcode
Explanation:
Choose min and max values and iterate through the array until we find minimum and maximum value

SOl 2:
Time Complexity :O(n) 3N/2-2 as 2T(n/2) + 2 for even (leaf nodes (L) = N / 2 // known
                                                        total nodes (n) = 2L - 1 = N - 1
                                                        internal nodes = n - L = N / 2 - 1
                                                        herefore, we have N - 2 comparisons.
                                                        Along with the N / 2 comparisons at the leaf nodes,
                                                        we have (3N / 2) - 2 total comparisons.)
Space Complexity: O(1)
Did this code successfully run on Leetcode : No Question on leetcode
Explanation:
Divide and conquer approach find min and max respectively on either side by breaking it into smaller sub problems.

Sol3:
Time Complexity :O(n)
Space Complexity :O(n) 3N/2-3
Explaination: Check in pairs and return min and max
'''
def pairMinMax(arr,n):
    max1 = min1 = index = 0
    if n%2 == 1:
        max1= arr[0]
        min1= arr[0]
        index = 1
    else:
        max1 = max(arr[0],arr[1])
        min1 = min(arr[0],arr[1])
        index = 2

    i = 0
    for i in range(index,len(arr)-1,i+2):
        if arr[i] > arr[i+1]:
            max1 = max(max1, arr[i])
            min1 = min(min, arr[i+1])
        else:
            max1 = max(max1,arr[i+1])
            min1 = min(min1, arr[i])

    return (min1,max1)

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

arr = [3,5,2,8,1,3]
print(pairMinMax(arr, len(arr)-1))
# Problem:
# Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

# Time Complexity : O(3n/2 -2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Not on leetcode
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:

def minMax(arr):
    # assign first two elements as min and max according to their values after comparison
    maxm = max(arr[0], arr[1]) 
    minm = min(arr[0], arr[1])

    # start traversing through the list from index 2 as 0,1 -> maxm, minm
    i = 2

    while i < len(arr)-1 :
        # compare the min and max with next pair and update the new values of min and max.
        if arr[i] < arr[i+1]:
            maxm = max(maxm, arr[i+1])
            minm = min(minm, arr[i])
        else:
            maxm = max(maxm, arr[i])
            minm = min(minm, arr[i+1])
        # increment the index by 2
        i+=2

    return minm, maxm 


# To test the code:
arr = [1000, 11, 445, 1, 330, 3000, 43]
print("The minimum and maximum values are: ", minMax(arr))
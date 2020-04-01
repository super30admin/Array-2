"""
Problem
Given an array of numbers of length N, find both the minimum and maximum. 
Follow up : Can you do it using less than 2 * (N - 2) comparison
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/)
// Any problem you faced while coding this : Had some back and forth in trying to 
set the low and high

// Your code here along with comments explaining your approach
Algorithm Explanation
- Assign min_val - arr[0], max_val = arr[n-1]
- Iterate towards the middle of the array
- Avoiding at least two comparisons by doing so.
"""
def min_max(arr):
    n = len(arr)
    min_val = arr[0]
    max_val = arr[n-1]

    i = 1, j = n-2
    while i < j:
        min_val = min(min_val,arr[i])
        max_val = max(max_val,arr[i])
        i+=1
        j-=1

    return min_val,max_val

if __name__ == '__main__':
    arr = [1,3,4,5,6,7]
    print(min_max,arr)
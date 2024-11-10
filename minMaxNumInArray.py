# // Time Complexity : O(n) for traversal
# // Space Complexity : O(1)  no extra space
# // Did this code successfully run on Leetcode : NA
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
# Initialize min as inf and max and -inf.
# Single loop through array, compare in that very loop itself.
# Alternatively we compare pairs to reduce Time complexity to 3n/2 rather than 2n.


# my thought process
class Solution:
    def minMaxArr(self,arr:list[int]):  
        size = len(arr)
        min = float('inf')
        max = -float('inf')

        for i in range(size):                     #O(2n)
            if arr[i] < min :
                min = arr[i]
            elif arr[i] > max:
                max = arr[i]

        print("Minimum element is:", min)
        print("Maximum element is:", max)



# Take pairs process
class Solution2:
    def minMaxArr(self,arr:list[int]):
        size = len(arr)
        mini = float('inf')
        maxi = -float(' inf')

        for i in range(0,size-1,2):                     # O(3n/2) 3 comparisons
            if arr[i] < arr[i+1]:                       # check pairs
                mini = min(mini,arr[i])
                maxi = max (maxi,arr[i+1])
            else:
                mini = min(mini,arr[i+1])
                maxi = max(maxi,arr[i])
        
            if size % 2 != 0:                           # O(1)
                mini = min(mini, arr[-1])
                maxi = max(maxi, arr[-1])
        print("Minimum element is:", mini)
        print("Maximum element is:", maxi)


arr1 = [3, 5, 4, 1, 9]
# Output: Minimum element is: 1
#         Maximum element is: 9

arr2 = [22, 14, 8, 17, 35, 3]
# Output:  Minimum element is: 3
#          Maximum element is: 35

Solution().minMaxArr(arr1)
print("* " *11)
Solution2().minMaxArr(arr2)



"""
Problem: Maximum and minimum of an array using minimum number of comparisons
Time Complexity: O(n)
Space Complexity: O(1)
Number of comparisons:
    If n is odd: 3*(n-1)/2
    If n is even: 1 Initial comparison for initializing min and max,
                  and 3(n-2)/2 comparisons for rest of the elements
                    =  1 + 3*(n-2)/2 = 3n/2 -2
"""


class Solution:
    def getMinMax(self, arr):
        n = len(arr)

        # if len(array) is even, initialize the first two elements as min and max
        if n % 2 == 0:
            mx = max(arr[0], arr[1])
            mn = min(arr[0], arr[1])
            # set the starting index for loop
            i = 2
        # if len(array) is odd, initialize the first element as min and max
        else:
            mn = mx = arr[0]
            # set the starting index for loop
            i = 1

        # In the while, pick the elements in pair and compare the pair with max and min so far
        while i < n-1:
            if arr[i] < arr[i+1]:
                mx = max(mx, arr[i+1])
                mn = min(mn, arr[i])
            else:
                mx = max(mx, arr[i])
                mn = min(mn, arr[i+1])
            # Increment the index by 2 as two elements are processed at a time
            i += 2
        return mx,mn


obj = Solution()
arr = [1000, 11, 445, 1, 330, 3000]
mx, mn = obj.getMinMax(arr)
print("Minimum element is", mn)
print("Maximum element is", mx)




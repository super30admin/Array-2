# Finding Minimum and Maximum

# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : NA 
# Any problem you faced while coding this : NA
# Your code here along with comments explaining your approach
# Approach
"""
Initializing minimum element by infinity and the maximum element by minus infinity
if the list has odd number of elements we ignore last element and consider it later
comparing elements in pairs and finding minimum and maximum among i.e. A[i] and A[i+1]
and updating the same.

"""
def findMinAndMax(Arr, n):
    maximum_element = float('-inf')
    minimum_element = float('inf')
    if n & 1:
        n = n - 1
    for i in range(0, n, 2):
        if Arr[i] > Arr[i + 1]:  # 1st comparison
            minimum = Arr[i + 1]
            maximum = Arr[i]
        else:
            minimum = Arr[i]
            maximum = Arr[i + 1]
        if maximum > maximum_element:  # 2nd comparison
            maximum_element = maximum
        if minimum < minimum_element:  # 3rd comparison
            minimum_element = minimum
    if n & 1:
        if Arr[n] > maximum_element: maximum_element = Arr[n]
        if Arr[n] < minimum_element: minimum_element = Arr[n]
    return maximum_element,minimum_element
if __name__ == '__main__':
    A = [9, 0, 1, 2, 3]
    result=findMinAndMax(A, len(A))
    print (result)

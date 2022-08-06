#  Maximum and minimum of an array using minimum number of comparisons
'''
Leetcode all test cases passed: Yes
class Solution:
  def getMinMax(arr):
        n is the length of arr
        Space Complexity: O(1)
        Time Complexity: O(n)
'''
class Solution:
  def getMinMax(arr):
    mi = float("inf")
    ma = float("-inf")
    i = 0
    while i < len(arr):
      if len(arr) - 1 != i:
        if arr[i] > arr[i+1]:
          mi = min(arr[i + 1],mi)
          ma = max(arr[i],ma)
        elif arr[i] < arr[i+1]:
          mi = min(arr[i],mi)
          ma = max(arr[i + 1],ma)
        else:
          mi = min(arr[i],mi)
          ma = max(arr[i],ma)  
        if len(arr) - 2 == i:
          i += 1
        else:
          i += 2
      else:
        mi = min(arr[i],mi)
        ma = max(arr[i],ma)
        i += 1

    return mi,ma

"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Not on leetcode
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
The intuition here is to compare numbers in pairs. We will take 2 adjascent numbers, compare the lesser one 
with the minimum and greater one with the maximum and subsequently change the minimum and the maximum.
With this approach, we are reducing the comparisons.
"""


def findminandmax(nums):
    if not nums:
        return None
    minimum = float('inf')
    maximum = float('-inf')
    for i in range(0, len(nums), 2):
        if i <= len(nums)-2:
            a = min(nums[i], nums[i+1])
            b = max(nums[i], nums[i+1])
            if a < minimum:
                minimum = a
            if b > maximum:
                maximum = b
        else:
            if nums[i] < minimum:
                minimum = nums[i]
            if nums[i] > maximum:
                maximum = nums[i]
    return([minimum, maximum])


arr = [8, 2, 5, 3, 7, 1, 9, 12, 4]
print(findminandmax(arr))

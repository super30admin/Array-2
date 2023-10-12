"""
Time complexity: O (n)
Space complexity: O (1)
Did this code successfully run on Leetcode : Ran it directly in IDE
Any problem you faced while coding this : No, used simple approach
"""
class pair:
    # Define a class with 2 attributes - min and max
    # Use this 
    def __init__(self):
        self.min = 0
        self.max = 0
 
def getMinMax(nums):
    minmax = pair()
    n = len(nums)
    # If there is only one element then return it as min and max both
    if n == 1:
        minmax.max = nums[0]
        minmax.min = nums[0]
        return minmax
 
    # If there are more than one elements, then initialize min
    # and max
    if nums[0] > nums[1]:
        minmax.max = nums[0]
        minmax.min = nums[1]
    else:
        minmax.max = nums[1]
        minmax.min = nums[0]
 
    for i in range(2, n):
        if nums[i] > minmax.max:
            minmax.max = nums[i]
        elif nums[i] < minmax.min:
            minmax.min = nums[i]
 
    return minmax
 
# Driver Code
if __name__ == "__main__":
    nums = [100, 29, 879, 7, -1, 0, 2000, 456]
    minmax = getMinMax(nums)
    print("Minimum element is", minmax.min)
    print("Maximum element is", minmax.max)

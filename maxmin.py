
"""
TC: o(3n/2)
SC: O(1)

Approach :  compare two consicutive element and from the result of this compare smaller element with global minimum and bigger element with global maximum ]
that way you can reduce the comarision from 2n to 3n/2
"""

def maxandmin(nums):
    maximum = -float('inf')
    minimum = float('inf')
    for i in range(0,len(nums),2):
        if len(nums) == i+1:
            maximum = max(nums[i],maximum)
            minimum = min(nums[i+1],minimum)
        if nums[i] > nums[i+1]:
            maximum = max(nums[i],maximum)
            minimum = min(nums[i+1],minimum)
        else:
            maximum = max(nums[i+1],maximum)
            minimum = min(nums[i],minimum)
    return maximum,minimum
nums = [3,8,9,11,3,14,16,21,27,18,2]
print(maxandmin(nums))
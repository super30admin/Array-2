"""
time: O(n)
space: O(1)
Leet: Not on Leet
Problems: None
"""

def minmax(nums):
    min1 = nums[0]
    max1 = nums[0]
    for i in range(0,len(nums),2):
        if i==len(nums)-1:
            max1 = max(max,nums[i])
            min1 = min(min,nums[i])
        elif nums[i]<nums[i+1] :
            min1 = min(nums[i],min)
            max1 = max(nums[i+1],max)
        else:
            min1 = min(nums[i+1],min)
            max1 = max(nums[i],max)

    return [min,max]

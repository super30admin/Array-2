#Time: O(n/2)
#Space:O(1)
#Camparisons: n/2
from typing import List

def findMaxMin(nums: List[int]):
    maxNum, minNum = 0, 0
    for i in range(0, len(nums), 2):
        if i+1 >= len(nums):
            maxNum = max(maxNum, nums[i])
            minNum = min(minNum, nums[i])
        elif nums[i] > nums[i+1]:
            maxNum = max(maxNum, nums[i])
            minNum = min(minNum, nums[i+1])
        else:
            maxNum = max(maxNum, nums[i+1])
            minNum = min(minNum, nums[i])
    return maxNum, minNum


print(findMaxMin([1,-9,5,2,7,0]))
print(findMaxMin([3,-2,4,6,-1]))
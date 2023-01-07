# Time Complexity :
# O(N)  - Size of the array

# Space Complexity :
# O(1) - There is no auxillary space being allocated

# Did this code successfully run on Leetcode :
#Yes

#Go through the array. When we see a number, change the location corresponding to it to negative (if it isn't negative already)
#Then go through the updated array - wherever we have a positive number, that corresponding value is missing from the array

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        #First pass to update values
        for i,elem in enumerate(nums):
            idx = abs(elem) - 1
            if nums[idx] > 0:
                nums[idx] *= -1
        #Second pass to use updated values to find missing values
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return result

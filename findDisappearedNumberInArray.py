# Make position "number - 1" as negative to indicate the presence of "number"
# At the end the positive numbers index + 1 indicates the absence 

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(len(nums)): # O(n)
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] = nums[idx] * -1
        print(nums)
        for i in range(len(nums)): #O(n)
            if nums[i]>0:
                result.append(i + 1)
        return result
# Time O(n) + O(n) = 2O(n), Space = O(1)

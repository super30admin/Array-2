# Time complexity: O(n)
# Space complexity: O(1)
class Solution:
    def findDisappearedNumbers(self, nums):
        if not nums:
            return []
        result = []
        for i in range(len(nums)):
            index = abs(nums[i])-1
            if nums[index] > 0:
                nums[index] *= -1
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        return result

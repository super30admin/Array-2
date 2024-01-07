# Problem: Find All Numbers Disappeared in an Array
# time: O(n)
# space: O(1)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []

        # Iterate through the array and mark indices as negative
        for num in nums:
            index = abs(num) - 1
            nums[index] = -abs(nums[index])

        # Find indices with positive values
        for i, num in enumerate(nums):
            if num > 0:
                result.append(i + 1)

        return result
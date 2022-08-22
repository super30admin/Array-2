class Solution:
    def findDisappearedNumbers(self, nums):
        for n in nums:
            i = abs(n) - 1
            nums[i] = -1 * abs(nums[i])

        result = []
        for i, n in enumerate(nums):
            if n > 0:
                result.append(i + 1)
        return result
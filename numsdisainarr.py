class Solution:
    def findDisappearedNumbers(self, nums):
        n = len(nums)

        for i in range(n):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] *= -1

        result = []
        for i in range(n):
            if nums[i] > 0:
                result.append(i + 1)

        return result

# TC - O(n)
# SC - O(1) # not using any additional space
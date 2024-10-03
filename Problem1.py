# Time Complexity = O(n) Space Complexity = O(1)

class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        n = len(nums)
        result = []
        for i in range(n):
            num = nums[i]
            idx = abs(num) - 1
            if nums[idx] > 0:
                nums[idx] *= -1

        for i in range(n):
            if nums[i] < 0:
                nums[i] *= -1
            else:
                result.append(i + 1)

        return result

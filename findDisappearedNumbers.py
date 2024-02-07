class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = []
        for i in range(n):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] = nums[idx] * -1
        for i in range(n):
            if nums[i] > 0:
                result.append(i + 1)
        return result

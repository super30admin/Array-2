class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return
        missing_nums = []

        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1

        for i in range(len(nums)):
            if nums[i] > 0:
                missing_nums.append(i + 1)
            else:
                nums[i] *= -1

        return missing_nums
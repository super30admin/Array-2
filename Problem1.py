class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums or not len(nums):
            return -1
        res = []
        for n in nums:
            i = abs(n) - 1
            nums[i] = abs(nums[i]) * -1
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i + 1)
            else:
                nums[i] *= -1
        return res
        # T: O(n), S: O(1)
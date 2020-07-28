class Solution:
    def MinorMax(self, nums: List[int]) -> None:
        if not nums:
            return [0,0]
        max = -99999
        min = 999999
        for i in range(len(nums)-2):
            if nums[i] < min:
                min = nums[i]
            elif nums[i] > max:
                max = nums[i]

        return [min, max]

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums is None or len(nums) == 0:
            return []
        res = []
        n = len(nums)
        for i in range(n):
            index = abs(nums[i])-1
            if nums[index] > 0:
                nums[index] *= -1
        for i in range(n):
            if nums[i] > 0:
                res.append(i+1)
            else:
                # if asked not to keep original array to the same as input passed
                nums[i] *= -1
        return res
        
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        for i in range(len(nums)):
            index = abs(nums[i])
            if nums[index-1] > 0:
                nums[index-1] = -1 * nums[index-1]
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
            else:
                nums[i] = -1 * nums[i]
        return res
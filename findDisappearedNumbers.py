class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []

        for i in range(len(nums)):
            indx = abs(nums[i]) - 1
            if nums[indx] > 0:  # +ve number
                nums[indx] *= -1
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i + 1)
            else:
                nums[i] *= -1
        return res


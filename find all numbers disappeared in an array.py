
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        temp = 0
        for i in range(len(nums)):
            temp = abs(nums[i]) - 1
            if nums[temp] > 0:
                nums[temp] = nums[temp] * (-1)

        result = []
        for i in range(len(nums)):
            if nums[i] >= 0:
                result.append(i + 1)
            else:
                nums[i] = nums[i] * (-1)
        return result



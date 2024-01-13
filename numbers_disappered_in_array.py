class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:       
        if nums == 0 or len(nums) == 0:
            return []
        n = len(nums)
        result = []
        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * -1
        for i in range(n):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] = nums[i] * -1
        return result



        
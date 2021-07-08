class Solution:
    def findDisappearedNumbers(self, nums) :
        if nums == None or len(nums) == 0:
            return 0

        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1
        result = []
        for i in range(1, len(nums) + 1):
            if nums[i - 1] > 0:
                result.append(i)

        return result

sol=Solution()
arr=[1,3,3,8,6,6,6,6,3,3]
print(sol.findDisappearedNumbers(arr))
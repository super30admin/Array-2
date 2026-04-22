# https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/

class Solution:
    def findDisappearedNumbers(self, nums):
        result = []
        n = len(nums)
        for i in range(n):
            curr = abs(nums[i])
            if nums[curr - 1] > 0:
                nums[curr - 1] *= -1
        for i in range(n):
            curr = nums[i]
            if curr > 0:
                result.append(i + 1)
            else:
                nums[i] *= -1
        return result


nums = [4,3,2,7,8,2,3,1]
sl = Solution()
print(sl.findDisappearedNumbers(nums))
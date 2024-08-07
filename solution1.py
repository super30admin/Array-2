# time: O(n)
# space: O(1)
class Solution(object):
    def findDisappearedNumbers(self, nums):
        nums.insert(0,0)
        res = []
        for i in range(len(nums)):
            if nums[abs(nums[i])] > 0:
                nums[abs(nums[i])] *= -1
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i)
        return res
        
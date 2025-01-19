# Multiply the index with -1 for those numbers if it's not negative already. Return the index of positive numbers
# TC: O(n)
# SC: O(1)
# Yes, this worked in leetcode

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if len(nums) == 0:
            return []
        n = len(nums)
        res = []
        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * -1
        for i in range(n):
            if nums[i] > 0:
                res.append(i + 1)
            else:
                nums[i] = nums[i] * -1
        return res

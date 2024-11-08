# TC: O(n)
# SC: O(1)
# The code successfully compiled in LC

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            if nums[i] > 0:
                if nums[nums[i]-1] > 0:
                    nums[nums[i]-1] = -nums[nums[i] - 1]
            else:
                if nums[abs(nums[i])-1] > 0:
                    nums[abs(nums[i])-1] = -nums[abs(nums[i])-1]
        res = []
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)
        return res

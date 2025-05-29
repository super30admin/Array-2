# Time Complexity - o(n)
# Space Complexity - o(1)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []

        for n in nums:
            idx = abs(n)
            if nums[idx-1]>0:
                nums[idx-1] *= -1

        for n in range(len(nums)):
            if nums[n]>0:
                res.append(n+1)

        return res
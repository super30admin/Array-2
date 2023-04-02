# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:

        res = []
        for i in nums:
            i = abs(i)
            if nums[i-1] > 0:
                nums[i-1] *= -1
        print(nums)
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i + 1)

        return res

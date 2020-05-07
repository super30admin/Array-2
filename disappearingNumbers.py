# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution:
    def findDisappearedNumbers(self, nums: [int]):
        result = []
        # edge case
        if not nums or len(nums) == 0:
            return result
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1  # making it negative
        return [i + 1 for i in range(len(nums)) if nums[i] > 0]


r = Solution()
nums = [4, 3, 2, 7, 8, 2, 3, 1]
print("Disappeared numbers are:", r.findDisappearedNumbers(nums))

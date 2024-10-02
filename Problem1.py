# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Disappeared Numbers

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = []
        # First loop: Mark each number's corresponding index negative
        for i in range(n):
            num = nums[i]
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] = nums[idx] * -1

        # Second loop: Collect the indices of positive numbers
        for i in range(n):
            if nums[i] < 0:
                nums[i] *= -1
            else:
                result.append(i + 1)

        return result
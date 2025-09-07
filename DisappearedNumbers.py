from typing import List
# Time complexity: O(n)
# Space complexity: O(1) since we are not considering the output as an extra space as it is auxiliary space.
# Did it run on leetcode: Yes

#The intuition is to use the nums array as the hashset itself. It works because it is in the range 1, n
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(len(nums)):
            if (nums[abs(nums[i]) - 1] < 0):
                continue
            nums[abs(nums[i]) - 1] = -nums[abs(nums[i]) - 1]

        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)

        return result

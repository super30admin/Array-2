# Time Complexity : O(n), where n is the size of the array
# Space Complexity : O(1), since the space occupied by the output array doesn't count towards the space complexity
# continued: That is a requirement of the problem itself
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = list()

        # change the state at the index where num is supposed to be
        for num in nums:
            if nums[abs(num) - 1] > 0:
                nums[abs(num) - 1] *= -1

        # check the indices where the state is unchanged
        for i, num in enumerate(nums):
            if num > 0:
                result.append(i + 1)

        return result

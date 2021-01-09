# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Since the constraints given are in the range 1 ≤ a[i] ≤ n,
# the intuition is to make the values at the index negative.
# Then check if the numbers in array are greater than zero and apeend it to output array


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        if len(nums) == 0:
            return res

        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            nums[index] = abs(nums[index]) * -1

        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i + 1)

        return res

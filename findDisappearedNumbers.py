# Time Complexity : O(n), where n is the length of the array
# Space Complexity : O(1), ignoring the output list (modified in-place)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Mark each number's corresponding index as negative
        for num in nums:
            index = abs(num) - 1
            nums[index] = -abs(nums[index])

        # Collect indexes that are still positive (i.e., missing numbers)
        result = []
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)

        return result

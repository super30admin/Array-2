# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Not on LeetCode
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Initialize the max and min to be the first and second element from array.
# Iterate over the array and check if maxnum is greater than nums[i] and minnum is less than nums[i]


class Solution:
    def MaximumandMinimum(self, nums):
        if len(nums) == 0:
            return 0

        if nums[0] > nums[1]:
            maxnum = nums[0]
            minnum = nums[1]
        else:
            maxnum = nums[1]
            minnum = nums[0]

        for i in range(2, len(nums)):
            if nums[i] > maxnum:
                maxnum = nums[i]
            elif nums[i] < minnum:
                minnum = nums[i]

        return (maxnum, minnum)


sol = Solution()
print(sol.MaximumandMinimum([10, 2, 1, 0, 6]))

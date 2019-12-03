# Time Complexity : Brute Force: O(n)
# Space Complexity : Brute Force: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

class Solution():
    def findMinMax(self, nums):
        if len(nums) == 0:
            return None, None
        elif len(nums) == 1:
            minimum, maximum = nums[0], nums[0]
        else:
            if nums[0] > nums[1]:
                maximum = nums[0]
                minimum = nums[1]
            else:
                maximum = nums[1]
                minimum = nums[0]
            for i in range(2, len(nums)):
                if nums[i] < minimum:
                    minimum = nums[i]
                elif nums[i] > maximum:
                        maximum = nums[i]
        return minimum, maximum


sol = Solution()
nums = [1000, 11, 445, 1, 330, 3000]
print(sol.findMinMax(nums))
nums = [1]
print(sol.findMinMax(nums))
nums = [1, - 1]
print(sol.findMinMax(nums))
nums = [1, 11]
print(sol.findMinMax(nums))
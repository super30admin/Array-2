#Time Complexity: O(n)
#Space Complexity: O(1)

class Solution:

    def findMinAndMax(self, nums):
        n = len(nums)
        i = 0

        if n % 2 == 0:
            if nums[0] < nums[1]:
                minimum = nums[0]
                maximum = nums[1]
            else:
                minimum = nums[1]
                maximum = nums[0]
            i = 2
        else:
            minimum = maximum = nums[0]
            i = 1

        while i < n - 1:
            if nums[i] < nums[i + 1]:
                minimum = min(minimum, nums[i])
                maximum = max(maximum, nums[i + 1])
            else:
                minimum = min(minimum, nums[i + 1])
                maximum = max(maximum, nums[i])
            i += 2

        return [minimum, maximum]
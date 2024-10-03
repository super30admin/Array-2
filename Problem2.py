# Time Complexity = O(n)

import math
class Solution:
    def findMinMax(self, nums: list[int]):
        n = len(nums)
        min_n = math.inf
        max_n = -math.inf

        for i in range(0, n, 2):
            print(i)
            if i == n - 1:
                min_n = min(nums[i], min_n)
                max_n = max(nums[i], max_n)
            elif nums[i] < nums[i + 1]:
                min_n = min(nums[i], min_n)
                max_n = max(nums[i + 1], max_n)
            else:
                min_n = min(nums[i + 1], min_n)
                max_n = max(nums[i], max_n)
        return min_n, max_n
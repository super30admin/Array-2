# In brute force we make 2 comparisons per number i.e. if it's max or min
# When we think of the numbers in pair by checking if nums[i] < nums[i+1] or the other way.
# We are making 3 comparisons for 2 elements instead of 4 with 2 min and max comparisons and 1 number comparison in if statement
# Comparisons: 3n/2 
class Solution:
    def findMinMax(self, nums: list[int]) -> list[int]:
        mini = float('inf')
        maxi = float('-inf')
        i = 0
        while i < len(nums) - 1:
            if nums[i] < nums[i+1]:
                mini = min(mini,nums[i])
                maxi = max(maxi,nums[i+1])
            else:
                mini = min(mini,nums[i + 1])
                maxi = max(maxi,nums[i])
            i += 2

        if len(nums) % 2 != 0:
            mini = min(nums[-1],mini)
            maxi = max(nums[-1],maxi)

        return [mini, maxi]
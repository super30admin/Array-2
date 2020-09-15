# Time complexity: O(N)
# Space complexity: O(1)
# Difficulty faced: No
# Not there on leetcode

def minMax(nums):
    if len(nums) > 0:
        minSofar = nums[0]
        maxSoFar = nums[0]

        for i in range(1,len(nums) -1):
            minSofar = min(minSofar, min(nums[i], nums[i + 1]))
            maxSoFar = max(maxSoFar, max(nums[i], nums[i + 1]))
        return minSofar, maxSoFar



print(minMax([4]))
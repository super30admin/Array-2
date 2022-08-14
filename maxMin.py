# Find the max and min in an array with least number of comparisons
# Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
# Time: O(N) : With pairwise comparisons total comparisons would be 1.5N, for N/2 pairs we are doing 3 comparisons each.
# Space: O(1)


def findMaxMin(nums):
    minNum, maxNum = float("inf"), float("-inf")

    # Make array of even length for pair-wise comparison
    if len(nums) % 2 != 0:
        nums.append(nums[-1])

    #Compare pairs
    for i in range(0, len(nums), 2):
        if nums[i] <= nums[i+1]: # 1st comparison
            minNum = min(minNum, nums[i])  # 2 comparisons
            maxNum = max(maxNum, nums[i+1])
        else:
            minNum = min(minNum, nums[i+1]) # 2 comparisons
            maxNum = max(maxNum, nums[i])

    return minNum, maxNum


nums = [3, -2, 7, 5, 0, 6, 10, 14, -9, 5, -100]
print(findMaxMin(nums))



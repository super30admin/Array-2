# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

# Solution:
"""
1. To find the missing numbers between 1 to n without extra space, we can use the state change approach.
2. Iterate through the array and keep track of the visited numbers by negating the value of their corresponding index.
3. Finally, iterate the array again to find the numbers without negation, which denote the missing numbers.
"""


def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
    if not nums or len(nums) == 0:
        return []

    result = []

    # Keep track of the seen numbers by negating the value of the corresponding indices
    for i in range(len(nums)):
        index = abs(nums[i]) - 1
        if nums[index] > 0:
            nums[index] *= -1

    # Get the missing numbers from indices with non-negated values
    for i in range(len(nums)):
        if nums[i] > 0:
            result.append(i + 1)
        else:
            nums[i] *= -1

    return result
# Time Complexity - O(n) 
# Space Complexity - O(n) 
def findDisappearedNumbers(nums):
    num_set = set(nums)
    n = len(nums)
    return [i for i in range(1, n + 1) if i not in num_set]

# Optimised Approach
# Time Complexity - O(n) 
# Space Complexity - O(1) 
def findDisappearedNumbers(nums):
    n = len(nums)
    for i in range(n):
        index = abs(nums[i]) - 1
        if nums[index] > 0:
            nums[index] *= -1

    result = []
    for i in range(n):
        if nums[i] > 0:
            result.append(i + 1)

    return result

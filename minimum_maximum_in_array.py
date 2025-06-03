# Time complexity - O(n) 
# Space complexity - O(1)

def findMinAndMax(nums):
    min_val = max_val = nums[0]
    for i in range(1, len(nums)):
        if nums[i] < min_val:
            min_val = nums[i]
        elif nums[i] > max_val:
            max_val = nums[i]
    return min_val, max_val


# Can we do it using less than 2 * (N - 2) comparisons?
# Time complexity - O(n) 
# Space complexity - O(1)

def findMinAndMax(nums):
    n = len(nums)
    if n % 2 == 0:
        min_val = min(nums[0], nums[1])
        max_val = max(nums[0], nums[1])
        start = 2
    else:
        min_val = max_val = nums[0]
        start = 1

    for i in range(start, n, 2):
        if nums[i] < nums[i + 1]:
            min_val = min(min_val, nums[i])
            max_val = max(max_val, nums[i + 1])
        else:
            min_val = min(min_val, nums[i + 1])
            max_val = max(max_val, nums[i])

    return min_val, max_val

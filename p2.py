#TIme Complexityy :O(n)
# Space COmplexity : O(1)
# Able to run on leetcode :Yes

def find_min_max_optimized(nums):
    if not nums:
        return None, None  

    if len(nums) == 1:
        return nums[0], nums[0]

    if nums[0] < nums[1]:
        min_val, max_val = nums[0], nums[1]
    else:
        min_val, max_val = nums[1], nums[0]

    for i in range(2, len(nums) - 1, 2):
        if nums[i] < nums[i + 1]:
            min_val = min(min_val, nums[i])
            max_val = max(max_val, nums[i + 1])
        else:
            min_val = min(min_val, nums[i + 1])
            max_val = max(max_val, nums[i])

    if len(nums) % 2 != 0:
        min_val = min(min_val, nums[-1])
        max_val = max(max_val, nums[-1])

    return min_val, max_val
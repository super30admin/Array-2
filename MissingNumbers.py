# TC = O(n)
# SC = O(1)
# We are mutating the original array. While traverse- each index- mark (index-1)'s value to negative(signifies element visited). Append result with (index +1) of the left over positive element.
def missing(nums):
    if not nums or len(nums) == 0:
        return []
    res = []
    for i in range(len(nums)):
        idx = abs(nums[i]) - 1
        if nums[idx] > 0: nums[idx] *= -1
    for i in range(len(nums)):
        if nums[i] > 0:
            res.append(i+1)
        else:
            nums[i] *= -1
    return res

nums = [4,3,2,7,8,2,3,1]
print(missing(nums))
    
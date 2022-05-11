'''
Time Complexity: O(N), where N is length of list nums
Space Complexity: O(1)
Comparisons: 1.5 N, where N is length of list nums
'''


def find_min_and_max(nums):
    mi, ma = nums[0], nums[0]
    l, r = 0, 1
    while r < len(nums):
        if nums[l] < nums[r]:
            mi = min(mi, nums[l])
            ma = max(ma, nums[r])
        else:
            ma = max(ma, nums[l])
            mi = min(mi, nums[r])
        l += 2
        r += 2
        if len(nums) % 2 == 1:
            mi = min(mi, nums[-1])
            ma = max(ma, nums[-1])
    return mi, ma

nums = [1,0,3,4,-8,1,6,7,-100]
mi, ma = find_min_and_max(nums)
print(mi, ma)


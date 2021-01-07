def findMinMax(nums):
    #Time Complexity: O(n)
    #Space Complexity: O(1)
    #No. of comparisons: 3n / 2
    #where, n is the length of nums

    sz = len(nums)
    if sz == 0:
        return None, None
    
    global_min = global_max = nums[0]
    start = 0 if sz % 2 == 0 else 1

    for i in range(start, sz, 2):
        if nums[i] <= nums[i+1]:
            pair_min, pair_max = nums[i], nums[i+1]
        else:
            pair_min, pair_max = nums[i+1], nums[i]
    
        if global_min > pair_min:
            global_min = pair_min
        if global_max < pair_max:
            global_max = pair_max

    return global_min, global_max

nums = [7,1,9,-8,80,89,-40,60,30,-35,107,4,0,18,-12]
nums_min, nums_max = findMinMax(nums)

print("Minimum is", nums_min)
print("Maximum is", nums_max)
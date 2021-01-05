def findMinMax(nums):
    min = nums[0]
    max = nums[0]

    for num in nums[1:]:
        if num < min:
            min = num
        if num > max:
            max = num

    return min, max

nums = [7,1,9,-8,80,89,-40,60,30,-35,107,4,0,18,-12]
min, max = findMinMax(nums)

print("Minimum is", min)
print("Maximum is", max)